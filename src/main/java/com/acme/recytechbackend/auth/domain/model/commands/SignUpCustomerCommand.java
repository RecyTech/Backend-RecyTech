package com.acme.recytechbackend.auth.domain.model.commands;

public record SignUpCustomerCommand(
        CreateUserCommand createUserCommand,
        String firstName,
        String lastName
) {
    public SignUpCustomerCommand(String mail, String password, String firstName, String lastName) {
        this(new CreateUserCommand(mail, password, "C"), firstName, lastName);
    }
    public boolean isOfType(Class<?> type) {return type.isInstance(createUserCommand); }
}
