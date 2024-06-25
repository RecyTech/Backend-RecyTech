package com.acme.recytechbackend.devices.domain.model.commands;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;

import java.util.List;

public record CreateDeviceCommand(
        String name, String description, Double precio, String ImagenURL, Customer customer,
        List<Category> categories, List<Brand> brands
        ) {
}
