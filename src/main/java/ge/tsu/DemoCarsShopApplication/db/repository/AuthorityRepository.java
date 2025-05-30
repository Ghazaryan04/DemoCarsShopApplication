package ge.tsu.DemoCarsShopApplication.db.repository;

import ge.tsu.DemoCarsShopApplication.db.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
