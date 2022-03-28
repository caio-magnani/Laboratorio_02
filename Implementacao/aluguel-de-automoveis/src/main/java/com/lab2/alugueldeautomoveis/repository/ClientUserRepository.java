package com.lab2.alugueldeautomoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab2.alugueldeautomoveis.model.ClientUser;

public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
    
}
