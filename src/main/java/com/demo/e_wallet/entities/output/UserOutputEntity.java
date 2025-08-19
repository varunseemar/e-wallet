package com.demo.e_wallet.entities.output;

import com.demo.e_wallet.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "e-wallet-users")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "first-name",nullable = false)
    private String firstName;

    @Column(name = "last-name",nullable = false)
    private String lastName;

    @Column(name = "phone-number",nullable = false,length = 10)
    private String phoneNumber;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "dob")
    private Instant dob;

    @Column(name = "role",nullable = false)
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "wallet-id",nullable = false)
    @JsonIgnore
    private WalletOutputEntity wallet;

    @JsonProperty
    public double getBalance(){
        return wallet.getBalance();
    }
}
