package dotted.user.application;

import dotted.login.application.dto.KakaoUserInfo;
import dotted.user.domain.User;
import dotted.user.domain.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserService {
    private final UserRepository userRepository;

    public User findOrCreateUser(User user) {
       return userRepository.findBySocialIdAndSocialType(user.getSocialId(), user.getSocialType())
               .orElseGet(() -> userRepository.save(user));
    }
}
