package com.Tobeto.RentaCar.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    CUSTOMER,
    CORPORATE_CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
