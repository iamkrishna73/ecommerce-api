package io.iamkrishna73.ecommerce.repositories;

import io.iamkrishna73.ecommerce.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findByProductId(Long productId);
}
