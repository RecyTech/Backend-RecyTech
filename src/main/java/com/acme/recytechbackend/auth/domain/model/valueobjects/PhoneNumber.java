package com.acme.recytechbackend.auth.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PhoneNumber(String phoneNumber) {
    public PhoneNumber(){ this(null); }
}
