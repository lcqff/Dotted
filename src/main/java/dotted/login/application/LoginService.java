package dotted.login.application;

import dotted.login.application.dto.KakaoTokenResponse;
import dotted.login.application.dto.KakaoUserInfo;
import dotted.login.application.dto.LoginResponse;
import dotted.login.utils.TokenExchanger;
import dotted.login.utils.UserInfoFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final TokenExchanger tokenExchanger;
    private final UserInfoFetcher userInfoFetcher;

    public LoginResponse getKakaoToken(String code) {
        KakaoTokenResponse tokenResponse = tokenExchanger.getToken(code);
        KakaoUserInfo userInfo = userInfoFetcher.getKaKaoUserInfo(tokenResponse.accessToken());

        return new LoginResponse(user.getId(),"temp Token");
    }
}
