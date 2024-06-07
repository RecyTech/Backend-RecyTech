package com.acme.recytechbackend.auth.application.internal.queryservices;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.queries.GetAllUserQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByEmailQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByIdQuery;
import com.acme.recytechbackend.auth.domain.services.*;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }
    @Override
    public List<User> handle(GetAllUserQuery query) { return userRepository.findAll(); }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) { return userRepository.findById(query.userId()); }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) { return userRepository.findByEmail(query.email()); }
}
