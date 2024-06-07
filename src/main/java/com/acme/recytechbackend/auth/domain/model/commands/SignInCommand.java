package com.acme.recytechbackend.auth.domain.model.commands;

public record SignInCommand(String email, String password) {
}
