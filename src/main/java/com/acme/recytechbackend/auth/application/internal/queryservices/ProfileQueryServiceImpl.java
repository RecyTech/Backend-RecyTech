package com.acme.recytechbackend.auth.application.internal.queryservices;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.queries.GetAllCustomersAsyncQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByUserIdAsyncQuery;
import com.acme.recytechbackend.auth.domain.services.ProfileQueryService;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final CustomerRepository customerRepository;

    public ProfileQueryServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> handle(GetAllCustomersAsyncQuery query) {return customerRepository.findAll();}

    @Override
    public Optional<Customer> handle(GetCustomerByUserIdAsyncQuery query) {
        return customerRepository.findCustomerByUserUserId(query.id());
    }

    @Override
    public Optional<Customer> handle(GetCustomerByIdQuery query) {
        return this.customerRepository.findById(query.customerId());
    }
}
