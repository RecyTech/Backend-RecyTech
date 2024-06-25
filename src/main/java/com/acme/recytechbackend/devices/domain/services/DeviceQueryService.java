package com.acme.recytechbackend.devices.domain.services;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDeviceByCustomerQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDeviceByStateQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetAllDevicesQuery;
import com.acme.recytechbackend.devices.domain.model.queries.GetDeviceByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DeviceQueryService {
    List<Device> handle(GetAllDevicesQuery query);
    List<Device> handle(GetAllDeviceByStateQuery query);
    Optional<Device> handle(GetDeviceByIdQuery query);
    List<Device> handle(GetAllDeviceByCustomerQuery query);
}
