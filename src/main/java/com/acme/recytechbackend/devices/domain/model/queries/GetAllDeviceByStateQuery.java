package com.acme.recytechbackend.devices.domain.model.queries;

public record GetAllDeviceByStateQuery(String state) {
    public GetAllDeviceByStateQuery {
        if (state == null || state.isEmpty()) {
            throw new IllegalArgumentException("state cannot be null or empty");
        }
    }
}
