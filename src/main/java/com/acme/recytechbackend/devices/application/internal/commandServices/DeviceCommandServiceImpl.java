package com.acme.recytechbackend.devices.application.internal.commandServices;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.domain.model.commands.CreateDeviceCommand;
import com.acme.recytechbackend.devices.domain.model.commands.UpdateDeviceListCommand;
import com.acme.recytechbackend.devices.domain.services.DeviceCommandService;
import com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {
    private final DeviceRepository deviceRepository;
    public DeviceCommandServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> handle(CreateDeviceCommand command) {
        var device = new Device(command);

        this.deviceRepository.save(device);

        device.getCategories().addAll(command.categories());
        device.getBrands().addAll(command.brands());
        this.deviceRepository.save(device);
        return Optional.of(device);
    }

    @Override
    public Optional<Device> handle(UpdateDeviceListCommand command) {
        var device = command.device();
        device.setState("No Disponible");
        this.deviceRepository.save(device);
        return Optional.of(device);
    }
}
