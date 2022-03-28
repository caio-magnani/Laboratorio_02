package com.lab2.alugueldeautomoveis.repository;

import com.lab2.alugueldeautomoveis.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
