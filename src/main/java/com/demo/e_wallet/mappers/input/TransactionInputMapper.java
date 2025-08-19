package com.demo.e_wallet.mappers.input;

import com.demo.e_wallet.entities.input.TransactionInputEntity;
import com.demo.e_wallet.enums.TransactionStatus;
import com.demo.e_wallet.models.TransactionModel;
import com.demo.e_wallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TransactionInputMapper {

    private final UserRepository userRepository;

    @Autowired
    public TransactionInputMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TransactionModel mapToModel(TransactionInputEntity transactionInputEntity){
        return TransactionModel.builder()
                .sender(this.userRepository.findUserByPhoneNumber(transactionInputEntity.getSenderId()))
                .receiver(this.userRepository.findUserByPhoneNumber(transactionInputEntity.getReceiverId()))
                .amount(transactionInputEntity.getAmount())
                .timeOfTransaction(Instant.now())
                .status(TransactionStatus.PENDING)
                .build();
    }
}
