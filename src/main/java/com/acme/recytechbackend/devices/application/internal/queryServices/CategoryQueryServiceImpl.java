package com.acme.recytechbackend.devices.application.internal.queryServices;

import com.acme.recytechbackend.devices.domain.model.aggregates.Category;
import com.acme.recytechbackend.devices.domain.model.queries.GetCategoryByIdQuery;
import com.acme.recytechbackend.devices.domain.services.CategoryQueryService;
import com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(GetCategoryByIdQuery query) {
        return this.categoryRepository.findCategoryById(query.id());
    }
}
