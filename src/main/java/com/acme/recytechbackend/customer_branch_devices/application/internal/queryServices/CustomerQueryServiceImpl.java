package com.acme.recytechbackend.customer_branch_devices.application.internal.queryServices;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.CustomerRepository;
import com.acme.recytechbackend.customer_branch_devices.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.customer_branch_devices.domain.services.CustomerQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final CustomerRepository customerRepository;
    public CustomerQueryServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> handle(GetCustomerByIdQuery query) {
        return this.customerRepository.findById(query.id());
    }
}
