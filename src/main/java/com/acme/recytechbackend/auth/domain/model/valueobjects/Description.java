package com.acme.recytechbackend.auth.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record Description(String description) {
    public Description() {this(null);}
}
