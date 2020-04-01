package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
