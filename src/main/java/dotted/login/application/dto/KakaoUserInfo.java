package dotted.login.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KakaoUserInfo(
    Long id,

    @JsonProperty("kakao_account")
    KakaoAccount kakaoAccount
) {
    public record KakaoAccount(
            @JsonProperty("profile_nickname_needs_agreement")
            Boolean profileNicknameNeedsAgreement,

            @JsonProperty("profile_image_needs_agreement")
            Boolean profileImageNeedsAgreement,
            Profile profile,
            String email,

            @JsonProperty("email_needs_agreement")
            Boolean emailNeedsAgreement,

            @JsonProperty("is_email_valid")
            Boolean isEmailValid,

            @JsonProperty("is_email_verified")
            Boolean isEmailVerified
    ){
        public record Profile(
                String nickname,

                @JsonProperty("profile_image_url")
                String profileImageUrl,

                @JsonProperty("is_default_image")
                Boolean isDefaultImage,

                @JsonProperty("is_default_nickname")
                Boolean isDefaultNickname
        ) {}
    }
}
