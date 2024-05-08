package dotted.login.application;

import dotted.login.application.dto.KakaoTokenResponse;
import dotted.login.application.dto.KakaoUserInfo;
import dotted.login.application.dto.LoginResponse;
import dotted.login.utils.JwtTokenProvider;
import dotted.login.utils.SocialType;
import dotted.login.utils.TokenExchanger;
import dotted.login.utils.UserInfoFetcher;
import dotted.user.application.UserService;
import dotted.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final TokenExchanger tokenExchanger;
    private final UserInfoFetcher userInfoFetcher;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse getKakaoToken(String code) {
        KakaoTokenResponse tokenResponse = tokenExchanger.getToken(code);
        KakaoUserInfo userInfo = userInfoFetcher.getKaKaoUserInfo(tokenResponse.accessToken());

        User user = userService.findOrCreateUser(User.builder()
                .socialId(userInfo.id())
                .socialType(SocialType.KAKAO)
                .email(userInfo.kakaoAccount().email())
                .name(userInfo.kakaoAccount().profile().nickname())
                .imageUrl(userInfo.kakaoAccount().profile().profileImageUrl())
                .build());
        String token = jwtTokenProvider.createToken(String.valueOf(user.getId()));
        return new LoginResponse(user.getId(),token);
    }
}
