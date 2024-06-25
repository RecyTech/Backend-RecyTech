package com.acme.recytechbackend.customer_branch_devices.domain.services;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.customer_branch_devices.domain.model.queries.GetCustomerByIdQuery;

import java.util.Optional;

public interface CustomerQueryService {
    Optional<Customer> handle(GetCustomerByIdQuery query);
}
