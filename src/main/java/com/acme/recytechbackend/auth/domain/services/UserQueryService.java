package com.acme.recytechbackend.auth.domain.services;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.queries.GetAllUserQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByEmailQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUserQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
