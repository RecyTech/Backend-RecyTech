package com.acme.recytechbackend.devices.application.internal.queryServices;

import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.queries.GetBrandByIdQuery;
import com.acme.recytechbackend.devices.domain.services.BrandQueryService;
import com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories.BrandRepository;
import com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandQueryServiceImpl implements BrandQueryService {

    private final BrandRepository brandRepository;

    public BrandQueryServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> handle(GetBrandByIdQuery query) {
        return this.brandRepository.findBrandById(query.id());
    }
}
