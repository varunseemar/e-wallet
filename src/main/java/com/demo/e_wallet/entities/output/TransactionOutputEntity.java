package com.demo.e_wallet.entities.output;

import com.demo.e_wallet.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false)
    private UserOutputEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id",nullable = false)
    private UserOutputEntity receiver;

    @Column(name = "amount",nullable = false)
    private double amount;

    @Column(name = "time",nullable = false)
    private Instant time;

    @Column(name = "status",nullable = false)
    private TransactionStatus status;

}
