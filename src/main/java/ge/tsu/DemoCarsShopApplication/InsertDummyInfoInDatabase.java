package ge.tsu.DemoCarsShopApplication;

import ge.tsu.DemoCarsShopApplication.db.service.UserService;
import ge.tsu.DemoCarsShopApplication.entiti.Car;
import ge.tsu.DemoCarsShopApplication.entiti.Comment;
import ge.tsu.DemoCarsShopApplication.repository.CarRepository;
import ge.tsu.DemoCarsShopApplication.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InsertDummyInfoInDatabase {

    private final JdbcUserDetailsManager userDetailsManager;
    private final CarRepository carRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final CommentRepository commentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        SecureRandom random = new SecureRandom();

        Car car1 = carRepository.save(
                new Car(null, "Toyota", 2015, 100000, "automatic", "green", "/image/car1.jpg", null, null)
        );
        Car car2 = carRepository.save(
                new Car(null, "BMW", 2025, 300000, "automatic", "white", "/image/car2.jpg", null, null)
        );
        Car car3 = carRepository.save(
                new Car(null, "Mercedes-benz", 2023, 356000, "mechanic", "grey", "/image/car3.jpg", null, null)
        );
        Car car4 = carRepository.save(
                new Car(null, "Audi", 2008, 3560, "mechanic", "white", "/image/car8.jpg", null, null)
        );
        Car car5 = carRepository.save(
                new Car(null, "Subaru", 2019, 35460, "mechanic", "blue", "/image/car13.jpg", null, null)
        );

        Car[] cars = {car1, car2, car3, car4, car5};

        fakeUsers().forEach(userDetailsManager::createUser);
        var users = userService.getAllUsers();


        for (Car car : cars) {
            for (int j = 0; j < random.nextInt(5) + 1; j++) { // 1-5 კომენტარი თითო მანქანაზე
                commentRepository.save(
                        new Comment(
                                null,
                                users.get(random.nextInt(users.size())),
                                "My super comment text" + j,
                                LocalDateTime.now(),
                                car
                        )
                );
            }
        }
    }

    private List<UserDetails> fakeUsers() {
        return List.of(
                // Administrator
                User.withUsername("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles("USER", "ADMIN")
                        .build(),
                // Sample users
                User.withUsername("vakho")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build(),
                User.withUsername("gio")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build(),
                User.withUsername("dato")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build(),
                User.withUsername("mari")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build(),
                User.withUsername("bob")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build()
        );
    }
}
