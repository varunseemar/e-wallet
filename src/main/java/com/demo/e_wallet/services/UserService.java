package com.demo.e_wallet.services;

import com.demo.e_wallet.exceptions.UserNotFoundException;
import com.demo.e_wallet.models.UserModel;
import com.demo.e_wallet.models.UserPrincipal;
import com.demo.e_wallet.models.WalletModel;
import com.demo.e_wallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final WalletService walletService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepository userRepository, WalletService walletService) {
        this.userRepository = userRepository;
        this.walletService = walletService;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        WalletModel walletModel = new WalletModel();
        WalletModel savedWalletModel = this.walletService.save(walletModel);
        userModel.setWallet(savedWalletModel);
        userModel.setPassword(this.bCryptPasswordEncoder.encode(userModel.getPassword()));
        return this.userRepository.save(userModel);
    }

    public UserModel update(long id,UserModel userModel){
        UserModel savedModel = this.getById(id);
        if(savedModel == null){
            return null;
        }
        userModel.setId(savedModel.getId());
        userModel.setWallet(savedModel.getWallet());
        userModel.setRole(savedModel.getRole());
        userModel.setPassword(this.bCryptPasswordEncoder.encode(userModel.getPassword()));
        return this.userRepository.save(userModel);
    }

    public boolean delete(long id){
        try{
            UserModel userModel = getById(id);
            this.userRepository.delete(id);
            this.walletService.delete(userModel.getWallet().getId());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel getById(long id){
        UserModel userModel = this.userRepository.findById(id);
        if(userModel == null){
            throw new UserNotFoundException("User Not Found.");
        }
        return userModel;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel userModel = this.userRepository.findUserByPhoneNumber(username);
            return new UserPrincipal(userModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
