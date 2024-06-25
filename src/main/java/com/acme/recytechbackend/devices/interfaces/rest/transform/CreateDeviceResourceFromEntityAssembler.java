package com.acme.recytechbackend.devices.interfaces.rest.transform;

import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;
import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.interfaces.rest.resources.CreateDeviceResource;

import java.util.List;
import java.util.stream.Collectors;

public class CreateDeviceResourceFromEntityAssembler {
    public static CreateDeviceResource toResourceFromEntity(Device entity) {
        List<Integer> categoryIds = entity.getCategories().stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        List<Integer> brandIds = entity.getBrands().stream()
                .map(Brand::getId)
                .collect(Collectors.toList());

        return new CreateDeviceResource(entity.getName(), entity.getDescription(), entity.getPrecio(), entity.getImagenURL() ,entity.getCustomer().getId() ,categoryIds, brandIds);
    }
}
