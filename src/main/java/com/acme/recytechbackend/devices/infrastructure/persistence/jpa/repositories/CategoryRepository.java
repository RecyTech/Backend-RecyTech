package com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories;

import com.acme.recytechbackend.devices.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoryById(Integer id);
}
