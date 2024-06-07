package com.acme.recytechbackend.devices.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "brands")
    @JsonBackReference
    private List<Device> devices;
    public Brand(String name) { this.name = name; }
    public Brand() {

    }
}
