package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPA репозиторий для пользователей
 */
public interface UserDetailsRepo extends JpaRepository<User,String> {

    @EntityGraph(attributePaths = { "subscriptions", "subscribers" })
    Optional<User> findById(String s);
}
