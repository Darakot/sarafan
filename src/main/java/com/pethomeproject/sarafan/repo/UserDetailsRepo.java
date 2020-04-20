package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPA репозиторий для пользователей
 */
public interface UserDetailsRepo extends JpaRepository<User,String> {
}
