package com.demo.e_wallet.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletModel {
    private long id;
    private double balance;
}
