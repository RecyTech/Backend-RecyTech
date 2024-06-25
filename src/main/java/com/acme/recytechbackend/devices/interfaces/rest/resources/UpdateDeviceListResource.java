package com.acme.recytechbackend.devices.interfaces.rest.resources;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;

import java.util.List;

public record UpdateDeviceListResource(String name, String description, Double precio, String imageURL,String Status,
                                       List<Category> categories, List<Brand> brands) {
}
