package com.acme.recytechbackend.devices.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Device> devices;

    public Category(String name) { this.name = name; }
    public Category() {

    }
}
