package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByFullName(String username);
}
