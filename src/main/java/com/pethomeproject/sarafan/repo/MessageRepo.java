package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.Message;
import com.pethomeproject.sarafan.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * JPA репозиторий для сообщений
 * Метод findAll помимо сообщений еще и забирает комменты
 */
public interface MessageRepo extends JpaRepository<Message, Long> {
    @EntityGraph(attributePaths = { "comments" })
    Page<Message> findByAuthorIn(List<User> users, Pageable pageable);
}
