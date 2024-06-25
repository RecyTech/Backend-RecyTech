package com.acme.recytechbackend.devices.domain.model.commands;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.aggregates.Device;

public record UpdateDeviceListCommand(Customer customer, Device device) {
}
