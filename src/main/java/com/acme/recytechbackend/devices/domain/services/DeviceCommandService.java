package com.acme.recytechbackend.devices.domain.services;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.domain.model.commands.CreateDeviceCommand;
import com.acme.recytechbackend.devices.domain.model.commands.UpdateDeviceListCommand;

import java.util.Optional;

public interface DeviceCommandService {
    Optional<Device> handle(CreateDeviceCommand command);
    Optional<Device> handle(UpdateDeviceListCommand command);
}
