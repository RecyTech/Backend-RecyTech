package com.acme.recytechbackend.devices.interfaces.rest.resources;

import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;

import java.util.List;

public record CreateDeviceResource(
        String name, String description, Double precio,String imageURL ,Long customerId,
        List<Integer> categories, List<Integer> brands
) {
}
