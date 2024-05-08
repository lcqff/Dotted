package dotted.login.application.dto;

public record LoginResponse(
        Long userId,
        String token
) {
}
