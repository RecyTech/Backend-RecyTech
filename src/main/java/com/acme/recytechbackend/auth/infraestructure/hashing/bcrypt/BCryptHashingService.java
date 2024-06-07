package com.acme.recytechbackend.auth.infraestructure.hashing.bcrypt;

import com.acme.recytechbackend.auth.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
