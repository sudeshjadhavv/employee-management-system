package com.example.ems.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ems.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
