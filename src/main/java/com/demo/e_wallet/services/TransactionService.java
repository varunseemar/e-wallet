package com.demo.e_wallet.services;

import com.demo.e_wallet.exceptions.TransactionNotFoundException;
import com.demo.e_wallet.exceptions.UserNotFoundException;
import com.demo.e_wallet.models.TransactionModel;
import com.demo.e_wallet.models.UserModel;
import com.demo.e_wallet.models.WalletModel;
import com.demo.e_wallet.repositories.TransactionRepository;
import com.demo.e_wallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final WalletService walletService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, UserService userService, WalletService walletService) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.walletService = walletService;
    }

    @Transactional
    public TransactionModel save(TransactionModel transactionModel){
        UserModel sender = this.userRepository.findUserByPhoneNumber(transactionModel.getSender().getPhoneNumber());
        UserModel receiver = this.userRepository.findUserByPhoneNumber(transactionModel.getReceiver().getPhoneNumber());
        if(sender == null){
            throw new UserNotFoundException("Sender cant be found.");
        }
        if(receiver == null){
            throw new UserNotFoundException("Receiver cant be found.");
        }
        if(transactionModel.getAmount() <= 0){
            throw new RuntimeException("Amount cant be less that or equal to 0.");
        }
        if(sender.getWallet().getBalance() < transactionModel.getAmount()){
            throw new RuntimeException("Insufficient Balance.");
        }
        WalletModel senderWallet = sender.getWallet();
        senderWallet.setBalance(senderWallet.getBalance() - transactionModel.getAmount());
        sender.setWallet(senderWallet);
        WalletModel updatedSenderWallet = this.walletService.update(senderWallet);

        WalletModel receiverWallet = receiver.getWallet();
        receiverWallet.setBalance(receiverWallet.getBalance() + transactionModel.getAmount());
        receiver.setWallet(receiverWallet);
        WalletModel updatedReceiverWallet = this.walletService.update(receiverWallet);

        return this.transactionRepository.save(transactionModel);
    }

    public TransactionModel getById(UUID id){
        TransactionModel transactionModel = this.transactionRepository.getById(id);
        if(transactionModel == null){
            throw new TransactionNotFoundException("Transaction doesn't exist.");
        }
        return transactionModel;
    }

    public List<TransactionModel> getAll(String id){
        UserModel userModel = this.userRepository.findUserByPhoneNumber(id);
        if(userModel == null){
            throw new UserNotFoundException("User cant be found.");
        }
        return this.transactionRepository.getAll(id);
    }
}
