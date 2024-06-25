package com.acme.recytechbackend.auth.domain.services;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.commands.UpdateCustomerDevicesCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Customer> handle(UpdateCustomerDevicesCommand command);
}
