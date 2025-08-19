package com.demo.e_wallet.entities.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInputEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private Instant dob;
}
