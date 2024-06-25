package com.acme.recytechbackend.devices.domain.model.aggregates;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.devices.domain.model.commands.CreateDeviceCommand;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private String imagenURL;

    @Setter
    private String state;

    @Setter
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "device_categories",
            joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "device_brands",
            joinColumns = @JoinColumn(name = "device_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    @JsonManagedReference
    private List<Brand> brands;

    public Device() {}

    public Device(CreateDeviceCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.precio = 0.0;
        this.imagenURL = command.ImagenURL();
        this.state = "Disponible";
        this.customer = null;
        this.categories = new ArrayList<>();
        this.brands = new ArrayList<>();
    }
}
