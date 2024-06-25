package com.acme.recytechbackend.auth.domain.model.commands;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;

public record UpdateCustomerDevicesCommand(Customer customer, int addProduct) {
}
