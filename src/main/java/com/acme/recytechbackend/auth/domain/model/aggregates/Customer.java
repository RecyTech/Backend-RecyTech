package com.acme.recytechbackend.auth.domain.model.aggregates;

import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import com.acme.recytechbackend.auth.domain.model.valueobjects.Country;
import com.acme.recytechbackend.auth.domain.model.valueobjects.Description;
import com.acme.recytechbackend.auth.domain.model.valueobjects.PersonName;
import com.acme.recytechbackend.auth.domain.model.valueobjects.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonName name;

    @Embedded
    private Description description;

    @Embedded
    private Country country;

    @Embedded
    private PhoneNumber phoneNumber;

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
                    String profileImgUrl) {
        this.user = user;
        this.name = new PersonName(firstName, lastName);
        this.description = new Description(description);
        this.country = new Country(country);
        this.phoneNumber = new PhoneNumber(phone);
        this.postedproducts = 0;
        this.profileImgUrl = profileImgUrl;
    }

    protected Customer() {

    }
}
