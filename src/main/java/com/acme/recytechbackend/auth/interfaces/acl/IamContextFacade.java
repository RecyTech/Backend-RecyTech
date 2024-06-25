package com.acme.recytechbackend.auth.interfaces.acl;

import com.acme.recytechbackend.auth.domain.model.aggregates.User;
import com.acme.recytechbackend.auth.domain.model.queries.GetUserByIdQuery;
import com.acme.recytechbackend.auth.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

@Service
public class IamContextFacade {

    private final UserQueryService userQueryService;

    public IamContextFacade(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    public User getUserById(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = this.userQueryService.handle(getUserByIdQuery);
        return user.orElse(null);
    }
}
