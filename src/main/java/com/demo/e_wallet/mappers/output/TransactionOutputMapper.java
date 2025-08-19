package com.demo.e_wallet.mappers.output;

import com.demo.e_wallet.entities.output.TransactionOutputEntity;
import com.demo.e_wallet.enums.TransactionStatus;
import com.demo.e_wallet.models.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionOutputMapper {

    private final UserOutputMapper outputMapper;

    @Autowired
    public TransactionOutputMapper(UserOutputMapper outputMapper) {
        this.outputMapper = outputMapper;
    }

    public TransactionModel mapToModel(TransactionOutputEntity transactionOutputEntity){
        return TransactionModel.builder()
                .id(transactionOutputEntity.getId())
                .sender(this.outputMapper.mapToModel(transactionOutputEntity.getSender()))
                .receiver(this.outputMapper.mapToModel(transactionOutputEntity.getReceiver()))
                .status(transactionOutputEntity.getStatus())
                .amount(transactionOutputEntity.getAmount())
                .timeOfTransaction(transactionOutputEntity.getTime())
                .build();
    }

    public TransactionOutputEntity mapFromModel(TransactionModel transactionModel){
        return TransactionOutputEntity.builder()
                .id(transactionModel.getId())
                .amount(transactionModel.getAmount())
                .sender(this.outputMapper.mapFromModel(transactionModel.getSender()))
                .receiver(this.outputMapper.mapFromModel(transactionModel.getReceiver()))
                .status(TransactionStatus.SUCCESS)
                .time(transactionModel.getTimeOfTransaction())
                .build();
    }
}
