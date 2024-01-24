package com.Tobeto.RentaCar.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    Moderator,

    Customer;

    @Override
    public String getAuthority() {
        return name();
    }
}
