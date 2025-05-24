package ge.tsu.DemoCarsShopApplication.db.repository;

import ge.tsu.DemoCarsShopApplication.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}