package com.acme.recytechbackend.auth.interfaces.rest.transform;

import com.acme.recytechbackend.auth.domain.model.commands.SignInCommand;
import com.acme.recytechbackend.auth.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
