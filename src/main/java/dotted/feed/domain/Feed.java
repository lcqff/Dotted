package dotted.feed.domain;

import dotted.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feed extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long schedule_item_id;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "feed")
    private List<FeedGroup> feedGroups;

    @OneToMany(mappedBy = "feed")
    private List<FeedUser>feedUsers;

    @Column(nullable = false)
    private Boolean isDeleted;
}
