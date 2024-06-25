package com.acme.recytechbackend.devices.domain.services;

import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.queries.GetBrandByIdQuery;

import java.util.Optional;

public interface BrandQueryService {
    Optional<Brand> handle(GetBrandByIdQuery query);
}
