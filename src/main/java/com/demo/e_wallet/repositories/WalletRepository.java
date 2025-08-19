package com.demo.e_wallet.repositories;

import com.demo.e_wallet.entities.output.WalletOutputEntity;
import com.demo.e_wallet.mappers.output.WalletOutputMapper;
import com.demo.e_wallet.models.WalletModel;
import com.demo.e_wallet.repositories.JpaRepository.WalletJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletRepository {
    private final WalletJpaRepository walletJpaRepository;
    private final WalletOutputMapper walletOutputMapper;

    @Autowired
    public WalletRepository(WalletJpaRepository walletJpaRepository, WalletOutputMapper walletOutputMapper) {
        this.walletJpaRepository = walletJpaRepository;
        this.walletOutputMapper = walletOutputMapper;
    }

    public WalletModel save(WalletModel walletModel){
        WalletOutputEntity walletOutputEntity = this.walletJpaRepository.save(this.walletOutputMapper.mapFromModel(walletModel));
        return this.walletOutputMapper.mapToModel(walletOutputEntity);
    }

    public WalletModel update(WalletModel walletModel){
        WalletOutputEntity walletOutputEntity = this.walletJpaRepository.save(this.walletOutputMapper.mapFromModel(walletModel));
        return this.walletOutputMapper.mapToModel(walletOutputEntity);
    }

    public boolean delete(long id){
        if(this.walletJpaRepository.existsById(id)){
            this.walletJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
