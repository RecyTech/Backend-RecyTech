package com.acme.recytechbackend.auth.interfaces.rest.transform;

import com.acme.recytechbackend.auth.domain.model.aggregates.*;
import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;

public class CustomerEntityFromResourceAssembler {
    public static Customer toCustomerFromCommand(SignUpCustomerCommand command, User user){
        return new Customer(
                user,
                command.firstName(),
                command.lastName(),
                "No description provided.",
                "No country provided.",
                "No phone provided.",
                0,
                "https://cdn-icons-png.flaticon.com/512/3237/3237472.png"
        );
    }
}
