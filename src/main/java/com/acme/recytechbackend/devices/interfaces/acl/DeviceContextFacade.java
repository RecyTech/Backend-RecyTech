package com.acme.recytechbackend.devices.interfaces.acl;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDeviceByStateQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDevicesQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetDeviceByIdQuery;
import com.acme.recytechbackend.devices.domain.services.DeviceQueryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DeviceContextFacade {
    private final DeviceQueryService deviceQueryService;

    public DeviceContextFacade(DeviceQueryService deviceQueryService) {
        this.deviceQueryService = deviceQueryService;
    }
    public List<Device> getAllDevices() {
        var getAllDevicesQuery = new GetAllDevicesQuery();
        return this.deviceQueryService.handle(getAllDevicesQuery);
    }

    public List<Device> getAllDevicesByState(String state) {
        try{
            var getAllDevicesByStateQuery = new GetAllDeviceByStateQuery(state);
            return this.deviceQueryService.handle(getAllDevicesByStateQuery);
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }
    }

    public Device getDeviceById(Long id) {
        var getDeviceByIdQuery = new GetDeviceByIdQuery(id);
        var device = this.deviceQueryService.handle(getDeviceByIdQuery);
        return device.orElse(null);
    }
}
