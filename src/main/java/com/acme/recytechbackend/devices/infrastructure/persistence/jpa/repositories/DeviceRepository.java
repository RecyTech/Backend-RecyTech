package com.acme.recytechbackend.devices.infrastructure.persistence.jpa.repositories;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAllByState(String state);
    List<Device> findAllByCustomer(Customer customer);
}
