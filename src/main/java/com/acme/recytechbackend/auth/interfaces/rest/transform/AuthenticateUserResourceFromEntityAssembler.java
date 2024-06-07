package com.acme.recytechbackend.auth.interfaces.rest.transform;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.interfaces.rest.resources.AuthenticateUserResource;

public class AuthenticateUserResourceFromEntityAssembler {
    public static AuthenticateUserResource toResourceFromEntity(User user) {
        return new AuthenticateUserResource(user.getUserId(), user.getEmail());
    }
}
