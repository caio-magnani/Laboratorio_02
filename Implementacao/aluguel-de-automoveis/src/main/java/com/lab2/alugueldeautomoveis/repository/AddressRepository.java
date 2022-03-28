package com.lab2.alugueldeautomoveis.repository;

import com.lab2.alugueldeautomoveis.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
