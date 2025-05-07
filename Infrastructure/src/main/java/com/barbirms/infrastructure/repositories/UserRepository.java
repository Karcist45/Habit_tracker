package com.barbirms.infrastructure.repositories;

import com.barbirms.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getUserByUsername(String username);
}