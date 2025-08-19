package com.demo.e_wallet.mappers.output;

import com.demo.e_wallet.entities.output.WalletOutputEntity;
import com.demo.e_wallet.models.WalletModel;
import org.springframework.stereotype.Component;

@Component
public class WalletOutputMapper {
    public WalletModel mapToModel(WalletOutputEntity walletOutputEntity){
        return WalletModel.builder()
                .id(walletOutputEntity.getId())
                .balance(walletOutputEntity.getBalance())
                .build();
    }

    public WalletOutputEntity mapFromModel(WalletModel walletModel){
        return WalletOutputEntity.builder()
                .id(walletModel.getId())
                .balance(walletModel.getBalance())
                .build();
    }
}
