package ge.tsu.DemoCarsShopApplication.entiti;

import ge.tsu.DemoCarsShopApplication.db.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to users table
    private User author; // The user who created the post

    @Lob
    @Column(nullable = false)
    private String content;
//
//    @Lob
//    private byte[] data;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }
}
