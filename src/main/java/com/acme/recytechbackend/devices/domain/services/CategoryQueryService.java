package com.acme.recytechbackend.devices.domain.services;

import com.acme.recytechbackend.devices.domain.model.aggregates.Category;
import com.acme.recytechbackend.devices.domain.model.queries.GetCategoryByIdQuery;

import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> handle(GetCategoryByIdQuery query);
}
