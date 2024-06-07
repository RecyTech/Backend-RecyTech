package com.acme.recytechbackend.auth.interfaces.rest;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import com.acme.recytechbackend.auth.domain.services.*;
import com.acme.recytechbackend.auth.interfaces.rest.resources.AuthenticateUserResource;
import com.acme.recytechbackend.auth.interfaces.rest.resources.SignInResource;
import com.acme.recytechbackend.auth.interfaces.rest.transform.*;
import com.acme.recytechbackend.auth.application.internal.commandservices.UserCommandServiceImpl;
import com.acme.recytechbackend.auth.interfaces.rest.resources.SignUpCustomerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/auth")
@Tag(name = "Users", description = "Operations related to users")
public class UserController {
    private final UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
    }

    @Operation(summary = "Create customer")
    @PostMapping("/register-customer")
    public ResponseEntity<User> createCustomer(@RequestBody SignUpCustomerResource resource) {
        SignUpCustomerCommand command = CustomerCommandFromSignUpCustomerResourceAssembler.toCommandFromResource(resource);
        Optional<User> user = userCommandService.handle(command);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to register developer");
        }
    }
    @Operation(summary = "sign in")
    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticateUserResource> signIn(@RequestBody SignInResource signInResource) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(signInResource);
        var authenticatedUser = userCommandService.handle(signInCommand);

        if(authenticatedUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var authenticatedUserResource = AuthenticateUserResourceFromEntityAssembler.toResourceFromEntity(
                authenticatedUser.get().getLeft());

        return ResponseEntity.ok(authenticatedUserResource);
    }
}
