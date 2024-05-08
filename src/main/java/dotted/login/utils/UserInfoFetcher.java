package dotted.login.utils;

import dotted.login.application.dto.KakaoUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class UserInfoFetcher {
    private final WebClient webClient;

    @Value("${spring.security.oauth2.client.provider.kakao.user-info-uri}")
    private String KAKAO_REQUEST_URI;

    public KakaoUserInfo getKaKaoUserInfo(String token) {
        Flux<KakaoUserInfo> response = webClient.post()
                .uri(KAKAO_REQUEST_URI)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(KakaoUserInfo.class);
        return response.blockFirst();
    }
}
