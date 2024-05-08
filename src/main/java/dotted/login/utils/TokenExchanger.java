package dotted.login.utils;

import dotted.login.application.dto.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class TokenExchanger {
    private final WebClient webClient;
    private static final String GRANT_TYPE = "authorization_code";

    @Value("${spring.security.oauth2.client.provider.kakao.token-uri}")
    private String KAKAO_REQUEST_URI;

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String KAKAO_CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String KAKAO_REDIRECT_URI;

    public KakaoTokenResponse getToken(String code) {
        String request_uri =
                KAKAO_REQUEST_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + KAKAO_CLIENT_ID + "&redirect_uri="
                        + KAKAO_REDIRECT_URI + "&code=" + code;
        Flux<KakaoTokenResponse> response = webClient.post()
                .uri(request_uri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve()
                .bodyToFlux(KakaoTokenResponse.class);

        return response.blockFirst();
    }
}
