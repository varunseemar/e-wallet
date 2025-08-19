package com.demo.e_wallet.entities.output;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "balance",nullable = false)
    private double balance = 0D;

}
