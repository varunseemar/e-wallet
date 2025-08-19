package com.demo.e_wallet.models;

import com.demo.e_wallet.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class UserModel {
    @NotNull
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
    @JsonIgnore
    private WalletModel wallet;
    private Instant dob;
    private UserRole role;
    @JsonProperty
    private long getWalletId(){
        return this.wallet.getId();
    }
}
