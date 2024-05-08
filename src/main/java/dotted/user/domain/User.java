package dotted.user.domain;

import dotted.base.BaseEntity;
import dotted.login.utils.SocialType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long socialId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String email;

    private String imageUrl;

    @OneToMany(mappedBy = "user")
    private List<UserGroup> userGroups;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Builder
    private User(String name, Long socialId, SocialType socialType, String email, String imageUrl,
                List<UserGroup> userGroups) {
        this.name = name;
        this.socialId = socialId;
        this.socialType = socialType;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userGroups = userGroups;
        this.isDeleted = false;
    }
}
