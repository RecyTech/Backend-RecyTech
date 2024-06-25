package com.acme.recytechbackend.auth.interfaces.acl;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.auth.domain.model.commands.UpdateCustomerDevicesCommand;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByIdQuery;
import com.acme.recytechbackend.auth.domain.model.queries.GetCustomerByUserIdAsyncQuery;
import com.acme.recytechbackend.auth.domain.services.ProfileCommandService;
import com.acme.recytechbackend.auth.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfileContextFacade {
    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfileContextFacade(ProfileQueryService profileQueryService,
                                ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    public Customer getCustomerByUserId(Long id){
        var getCustomerByUserIdQuery = new GetCustomerByUserIdAsyncQuery(id);
        var customer = this.profileQueryService.handle(getCustomerByUserIdQuery);
        return customer.orElse(null);
    }

    public void updateCustomerDevices(Long customerId){
        var customer = profileQueryService.handle(new GetCustomerByIdQuery(customerId));
        if (customer.isEmpty())return;

        var conut = customer.get().getPostedproducts();
        var command = new UpdateCustomerDevicesCommand(customer.get(), conut+1);
        var updateCustomer = this.profileCommandService.handle(command);
    }
}
