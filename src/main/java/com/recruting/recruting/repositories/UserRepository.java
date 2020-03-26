package com.recruting.recruting.repositories;

import com.recruting.recruting.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
}
