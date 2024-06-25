package com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories;

import com.acme.recytechbackend.auth.domain.model.aggregates.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByUserUserId(Long userId);
}
