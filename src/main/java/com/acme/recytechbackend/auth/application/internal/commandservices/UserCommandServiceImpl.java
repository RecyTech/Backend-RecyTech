package com.acme.recytechbackend.auth.application.internal.commandservices;

import com.acme.recytechbackend.auth.application.internal.outboundservices.hashing.HashingService;
import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.aggregates.*;
import com.acme.recytechbackend.auth.domain.model.commands.CreateUserCommand;
import com.acme.recytechbackend.auth.domain.model.commands.SignInCommand;
import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import com.acme.recytechbackend.auth.domain.services.*;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.CustomerRepository;
import com.acme.recytechbackend.auth.infraestructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    private final HashingService hashingService;

    public UserCommandServiceImpl(UserRepository userRepository, CustomerRepository customerRepository, HashingService hashingService) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.hashingService = hashingService;
    }

    @Override
    public Optional<User> handle(SignUpCustomerCommand command) {
        String email = command.createUserCommand().email();
        userRepository.findByEmail(email).ifPresent(user -> {
            throw new IllegalArgumentException("User with email " + email + " already exists");
        });

        User user = new User(new CreateUserCommand(
                email,
                hashingService.encode(command.createUserCommand().password()),
                command.createUserCommand().userType()
        ));
        userRepository.save(user);

        Customer customer = new Customer(
                user,
                command.firstName(),
                command.lastName(),
                "No description provided.",
                "No country provided.",
                "No phone provided.",
                "https://cdn-icons-png.flaticon.com/512/3237/3237472.png"
        );
        customerRepository.save(customer);

        return Optional.of(user);
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        if (!hashingService.matches(command.password(), user.get().getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return Optional.of(ImmutablePair.of(user.get(), "token"));
    }
}

