package com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories;

import com.acme.recytechbackend.auth.domain.model.aggregates.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
