package com.acme.recytechbackend.devices.interfaces.rest.transform;

import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import com.acme.recytechbackend.devices.interfaces.rest.resources.DeviceResource;

public class DeviceResourceFromEntityAssembler {
    public static DeviceResource toResourceFromEntity(Device entity){
        if("Disponible".equals(entity.getState())) {
            return new DeviceResource(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrecio(), entity.getImagenURL(),entity.getState(), entity.getCustomer().getId(), entity.getCategories(), entity.getBrands());
        }
        if("No Disponible".equals(entity.getState())) {
            return new DeviceResource(entity.getId(), entity.getName(), entity.getDescription(),entity.getPrecio(), entity.getImagenURL(),entity.getState(), entity.getCategories(), entity.getBrands());
        }
        throw new IllegalArgumentException("El estado no es valido");
    }
}
