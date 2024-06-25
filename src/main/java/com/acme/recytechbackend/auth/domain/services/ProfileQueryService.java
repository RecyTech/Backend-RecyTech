package com.acme.recytechbackend.auth.domain.services;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.queries.GetAllCustomersAsyncQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByUserIdAsyncQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Customer> handle(GetAllCustomersAsyncQuery query);
    Optional<Customer> handle(GetCustomerByUserIdAsyncQuery query);
    Optional<Customer> handle(GetCustomerByIdQuery query);
}
