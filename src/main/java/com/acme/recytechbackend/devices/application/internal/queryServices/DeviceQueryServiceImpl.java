package com.acme.recytechbackend.devices.application.internal.queryServices;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDeviceByCustomerQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDeviceByStateQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDevicesQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetDeviceByIdQuery;
import com.acme.recytechbackend.devices.domain.services.DeviceQueryService;
import com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceQueryServiceImpl  implements DeviceQueryService {

    private final DeviceRepository deviceRepository;
    public DeviceQueryServiceImpl(DeviceRepository deviceRepository) { this.deviceRepository = deviceRepository;}


        @Override
        public List<Device> handle(GetAllDevicesQuery query) {return this.deviceRepository.findAll(); }

        @Override
        public List<Device> handle(GetAllDeviceByStateQuery query) {
            return this.deviceRepository.findAllByState(query.state());
        }

        @Override
        public Optional<Device> handle(GetDeviceByIdQuery query) {return this.deviceRepository.findById(query.id()); }

        @Override
        public List<Device> handle(GetAllDeviceByCustomerQuery query) {
        return this.deviceRepository.findAllByCustomer(query.customer());
        }
}
