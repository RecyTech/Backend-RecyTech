package com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories;

import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findBrandById(Integer id);
}
