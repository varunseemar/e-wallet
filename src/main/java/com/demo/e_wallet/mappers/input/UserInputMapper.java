package com.demo.e_wallet.mappers.input;

import com.demo.e_wallet.entities.input.UserInputEntity;
import com.demo.e_wallet.enums.UserRole;
import com.demo.e_wallet.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {
    public UserModel mapToModel(UserInputEntity userInputEntity){
        return UserModel.builder()
                .id(userInputEntity.getId())
                .firstName(userInputEntity.getFirstName())
                .lastName(userInputEntity.getLastName())
                .password(userInputEntity.getPassword())
                .phoneNumber(userInputEntity.getPhoneNumber())
                .dob(userInputEntity.getDob())
                .role(UserRole.USER)
                .build();
    }
}
