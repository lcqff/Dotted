package dotted.login.api;

import dotted.login.application.LoginService;
import dotted.login.application.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/oauth2/code/kakao")
    public ResponseEntity<LoginResponse> getKakaoToken(@RequestParam("code") String code) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.getKakaoToken(code));
    }
}
