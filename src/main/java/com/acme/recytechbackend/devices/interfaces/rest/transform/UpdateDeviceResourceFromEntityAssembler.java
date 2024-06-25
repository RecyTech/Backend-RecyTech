package com.acme.recytechbackend.devices.interfaces.rest.transform;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.interfaces.rest.resources.UpdateDeviceListResource;

public class UpdateDeviceResourceFromEntityAssembler {
    public static UpdateDeviceListResource toResourceFromEntity(Device entity) {
        return new UpdateDeviceListResource(entity.getName(), entity.getDescription(), entity.getPrecio(), entity.getImagenURL() ,entity.getState(), entity.getCategories(), entity.getBrands());
    }
}
