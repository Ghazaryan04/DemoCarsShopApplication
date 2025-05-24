package ge.tsu.DemoCarsShopApplication.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BRAND", unique = true, nullable = false)
    private String brand;
    @Column(name = "_YEAR", nullable = false)
    private Integer year;
    @Column(name = "PRICE", nullable = false)
    private Integer price;
    @Column(name = "TRANSMISSION", nullable = false)
    private String transmission;
    @Column(name = "COLOR", nullable = false)
    private String color;

    @Column(name = "IMG_URL")
    private String imgUrl;
    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "car")
    private List<Comment> comments;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }
}
