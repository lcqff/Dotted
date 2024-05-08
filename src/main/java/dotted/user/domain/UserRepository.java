package dotted.user.domain;

import dotted.login.utils.SocialType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySocialIdAndSocialType(Long socialId, SocialType socialType);
}
