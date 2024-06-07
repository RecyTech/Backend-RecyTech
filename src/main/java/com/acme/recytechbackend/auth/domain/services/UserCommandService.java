package com.acme.recytechbackend.auth.domain.services;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.commands.SignInCommand;
import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCustomerCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
