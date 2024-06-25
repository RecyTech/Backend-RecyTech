package com.acme.recytechbackend.auth.application.internal.commandservices;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.commands.UpdateCustomerDevicesCommand;
import com.acme.recytechbackend.auth.domain.services.ProfileCommandService;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final CustomerRepository customerRepository;

    public ProfileCommandServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Optional<Customer> handle(UpdateCustomerDevicesCommand command) {
        var updateCustomer = command.customer();
        updateCustomer.setPostedproducts(command.addProduct());
        this.customerRepository.save(updateCustomer);
        return Optional.of(updateCustomer);
    }
}
