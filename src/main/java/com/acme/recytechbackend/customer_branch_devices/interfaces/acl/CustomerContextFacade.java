package com.acme.recytechbackend.customer_branch_devices.interfaces.acl;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.customer_branch_devices.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.customer_branch_devices.domain.services.CustomerQueryService;
import org.springframework.stereotype.Service;

@Service
public class CustomerContextFacade {
    private final CustomerQueryService customerQueryService;
    public CustomerContextFacade(CustomerQueryService customerQueryService) {
        this.customerQueryService = customerQueryService;
    }
    public Customer getCustomerById(Long id) {
        var getCustomerByIdQuery = new GetCustomerByIdQuery(id);
        var customer = this.customerQueryService.handle(getCustomerByIdQuery);
        return customer.orElse(null);
    }
}
