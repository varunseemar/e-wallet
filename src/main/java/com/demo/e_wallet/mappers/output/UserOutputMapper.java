package com.demo.e_wallet.mappers.output;

import com.demo.e_wallet.entities.output.UserOutputEntity;
import com.demo.e_wallet.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    private final WalletOutputMapper walletOutputMapper;

    @Autowired
    public UserOutputMapper(WalletOutputMapper walletOutputMapper) {
        this.walletOutputMapper = walletOutputMapper;
    }

    public UserModel mapToModel(UserOutputEntity userOutputEntity){
        return UserModel.builder()
                .id(userOutputEntity.getId())
                .firstName(userOutputEntity.getFirstName())
                .lastName(userOutputEntity.getLastName())
                .phoneNumber(userOutputEntity.getPhoneNumber())
                .password(userOutputEntity.getPassword())
                .dob(userOutputEntity.getDob())
                .role(userOutputEntity.getRole())
                .wallet(this.walletOutputMapper.mapToModel(userOutputEntity.getWallet()))
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel){
        return UserOutputEntity.builder()
                .id(userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .dob(userModel.getDob())
                .password(userModel.getPassword())
                .role(userModel.getRole())
                .wallet(this.walletOutputMapper.mapFromModel(userModel.getWallet()))
                .phoneNumber(userModel.getPhoneNumber())
                .build();
    }
}
