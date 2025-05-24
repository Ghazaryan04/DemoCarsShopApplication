package ge.tsu.DemoCarsShopApplication.service;

import ge.tsu.DemoCarsShopApplication.entiti.Comment;
import ge.tsu.DemoCarsShopApplication.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public Page<Comment> getAllCommentsByAuthor(String authorUsername, int page, int size) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Order.desc("createdDate")) // Order by "createdAt" descending
        );
        if (authorUsername != null) {
            return commentRepository.findAllByAuthorUsername(authorUsername, pageable);
        } else {
            return commentRepository.findAll(pageable);
        }
    }
}
