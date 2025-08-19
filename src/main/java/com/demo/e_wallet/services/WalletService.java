package com.demo.e_wallet.services;

import com.demo.e_wallet.clients.PaymentGatewayClient;
import com.demo.e_wallet.dto.PaymentGatewayRequest;
import com.demo.e_wallet.exceptions.UserNotFoundException;
import com.demo.e_wallet.models.UserModel;
import com.demo.e_wallet.models.WalletModel;
import com.demo.e_wallet.repositories.UserRepository;
import com.demo.e_wallet.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final PaymentGatewayClient paymentGatewayClient;

    @Autowired
    public WalletService(WalletRepository walletRepository, UserRepository userRepository, PaymentGatewayClient paymentGatewayClient) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
        this.paymentGatewayClient = paymentGatewayClient;
    }

    public WalletModel save(WalletModel walletModel){
        return this.walletRepository.save(walletModel);
    }

    public WalletModel update(WalletModel walletModel){
        return this.walletRepository.update(walletModel);
    }

    public boolean delete(long id){
        return this.walletRepository.delete(id);
    }

    public boolean addMoney(String username, double amount){
        UserModel userModel = this.userRepository.findUserByPhoneNumber(username);
        if(userModel == null){
            throw new UserNotFoundException("User not found.");
        }
        WalletModel walletModel = userModel.getWallet();
        try{
            this.paymentGatewayClient.addMoney(new PaymentGatewayRequest(amount));
        }
        catch(RuntimeException e){
            return false;
        }
        walletModel.setBalance(walletModel.getBalance() + amount);
        this.walletRepository.update(walletModel);
        return true;
    }
}
