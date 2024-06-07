package com.acme.recytechbackend.auth.interfaces.rest.transform;

import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import com.acme.recytechbackend.auth.interfaces.rest.resources.SignUpCustomerResource;

public class CustomerCommandFromSignUpCustomerResourceAssembler {
    public static SignUpCustomerCommand toCommandFromResource(SignUpCustomerResource signUpCustomerResource) {
        return new SignUpCustomerCommand(signUpCustomerResource.mail(), signUpCustomerResource.password(), signUpCustomerResource.firstName(), signUpCustomerResource.lastName());
    }
}
