package com.demo.e_wallet.dto;

import lombok.*;

@Data
@Setter
@Getter
public class AuthResponse {
    private final String token;

    public AuthResponse(String token) { this.token = token; }
}
