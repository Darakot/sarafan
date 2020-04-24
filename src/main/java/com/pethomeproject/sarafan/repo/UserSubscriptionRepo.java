package com.pethomeproject.sarafan.repo;

import com.pethomeproject.sarafan.domain.User;
import com.pethomeproject.sarafan.domain.UserSubscription;
import com.pethomeproject.sarafan.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {

    List<UserSubscription> findBySubscriber(User user);
}
