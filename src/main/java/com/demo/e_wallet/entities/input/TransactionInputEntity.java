package com.demo.e_wallet.entities.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionInputEntity {
    private String senderId;
    private String receiverId;
    private double amount;
}
