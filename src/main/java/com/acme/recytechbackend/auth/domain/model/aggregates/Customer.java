package com.acme.recytechbackend.auth.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String description = "No description provided.";
    private String country = "No country provided.";
    private String phone = "999 999 999";
    private int postedproducts = 0;
    private String profileImgUrl = "https://cdn-icons-png.flaticon.com/512/3237/3237472.png";

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Customer(User user,
                    String firstName,
                    String lastName,
                    String description,
                    String country,
                    String phone,
                    int postedproducts,
                    String profileImgUrl) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.country = country;
        this.phone = phone;
        this.postedproducts = postedproducts;
        this.profileImgUrl = profileImgUrl;
    }

    protected Customer() {

    }
}
