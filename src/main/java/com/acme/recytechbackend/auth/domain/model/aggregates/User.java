package com.acme.recytechbackend.auth.domain.model.aggregates;


import com.acme.recytechbackend.auth.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userType;

    protected User() {

    }
    public User(CreateUserCommand command){
        this.email = command.email();
        this.password = command.password();
        this.userType = command.userType();
    }

}
