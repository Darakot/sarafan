package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA репозиторий для коментов
 */
public interface CommentRepo extends JpaRepository<Comment, Long> {
}