package com.acme.recytechbackend.auth.interfaces.rest.resources;

public record SignUpCustomerResource(
        String mail,
        String password,
        String firstName,
        String lastName
) {
}
