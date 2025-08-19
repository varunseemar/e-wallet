package com.demo.e_wallet.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private final UserModel userModel;

    @Autowired
    public UserPrincipal(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userModel.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return this.userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userModel.getPhoneNumber();
    }
}
