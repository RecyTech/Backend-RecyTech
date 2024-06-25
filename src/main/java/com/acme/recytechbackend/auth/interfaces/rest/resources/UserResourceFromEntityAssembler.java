package com.acme.recytechbackend.auth.interfaces.rest.resources;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(user.getUserId(), user.getUserType());
    }
}
