package com.acme.recytechbackend.auth.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Country(String country) {
    public Country() {this(null);}
}