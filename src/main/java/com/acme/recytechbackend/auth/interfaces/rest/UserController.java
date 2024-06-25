package com.acme.recytechbackend.auth.interfaces.rest;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.commands.SignUpCustomerCommand;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByEmailQuery;
import com.acme.recytechbackend.auth.domain.services.*;
import com.acme.recytechbackend.auth.interfaces.rest.resources.*;
import com.acme.recytechbackend.auth.interfaces.rest.transform.*;
import com.acme.recytechbackend.auth.application.internal.commandservices.UserCommandServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/auth")
@Tag(name = "Users", description = "Operations related to users")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }
    @Operation(summary = "Get user by email")
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResource> getUserByEmail(@PathVariable String email) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var user = this.userQueryService.handle(getUserByEmailQuery);
        if (user.isEmpty()) return ResponseEntity.notFound().build();
        var resource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Create customer")
    @PostMapping("/register-customer")
    public ResponseEntity<UserResource> createCustomer(@RequestBody SignUpCustomerResource resource) {
        var command = CustomerCommandFromSignUpCustomerResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.handle(command);

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
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
