package com.acme.recytechbackend.auth.interfaces.rest;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.queries.GetAllCustomersAsyncQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByUserIdAsyncQuery;
import com.acme.recytechbackend.auth.domain.services.ProfileQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/profiles")
@Tag(name= "Profiles", description = "Operations related to profiles")
public class ProfileController {
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileQueryService profileQueryService) {
        this.profileQueryService = profileQueryService;
    }

    @Operation(summary = "Get all customers")
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(profileQueryService.handle(new GetAllCustomersAsyncQuery()));
    }

    @Operation(summary = "Get all customers by id")
    @GetMapping("/customers/{userId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long userId) {
        var getCustomerByUserIdQuery = new GetCustomerByUserIdAsyncQuery(userId);
        var customer = profileQueryService.handle(getCustomerByUserIdQuery);
        if (customer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer.get());
    }
}
