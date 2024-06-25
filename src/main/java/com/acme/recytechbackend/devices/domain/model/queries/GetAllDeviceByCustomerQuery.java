package com.acme.recytechbackend.devices.domain.model.queries;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;

public record GetAllDeviceByCustomerQuery(Customer customer) {
}
