package com.devAsk.api.repository;

import com.devAsk.api.entity.User;
import com.devAsk.api.enums.Permission;
import com.devAsk.api.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
    public Optional<User> findByEmail(String email);
}
