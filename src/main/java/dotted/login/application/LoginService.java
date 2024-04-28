package dotted.login.application;

import dotted.login.application.dto.KakaoTokenResponse;
import dotted.login.application.dto.LoginResponse;
import dotted.login.utils.TokenExchanger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final TokenExchanger tokenExchanger;

    public LoginResponse getKakaoToken(String code) {
        KakaoTokenResponse tokenResponse = tokenExchanger.getToken(code);
        return new LoginResponse(user.getId(),"temp Token");
    }
}
