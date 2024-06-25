package com.acme.recytechbackend.devices.interfaces.rest.resources;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;

import java.util.List;

public record DeviceResource( Long id, String name, String description, Double precio, String imgenURL, String state,Long customerId, List<Category> categories, List<Brand> brands) {
    public DeviceResource {
        if (id == null || name == null || description == null) {
            throw new NullPointerException("id is null");
        }
    }

    public DeviceResource(Long id, String name, String description, Double precio, String imgenURL, String state, List<Category> categories, List<Brand> brands) {
        this(id, name, description, precio, imgenURL,state,null, categories, brands);
    }
}