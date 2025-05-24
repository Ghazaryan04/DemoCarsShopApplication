package ge.tsu.DemoCarsShopApplication.repository;

import ge.tsu.DemoCarsShopApplication.entiti.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findAllByAuthorUsername(String authorUsername, Pageable pageable);
}