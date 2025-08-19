package com.demo.e_wallet.models;

import com.demo.e_wallet.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    private UUID id;
    @NotNull
    @JsonIgnore
    private UserModel sender;
    @NotNull
    @JsonIgnore
    private UserModel receiver;
    @NotNull
    @DecimalMin("1.0")
    private double amount;
    @NotNull
    private Instant timeOfTransaction;
    private TransactionStatus status;

    @JsonProperty
    private long getSenderId(){
        return this.sender.getId();
    }

    @JsonProperty
    private long getReceiverId(){
        return this.receiver.getId();
    }
}
