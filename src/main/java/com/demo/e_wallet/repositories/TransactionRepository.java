package com.demo.e_wallet.repositories;

import com.demo.e_wallet.entities.output.TransactionOutputEntity;
import com.demo.e_wallet.mappers.output.TransactionOutputMapper;
import com.demo.e_wallet.models.TransactionModel;
import com.demo.e_wallet.repositories.JpaRepository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TransactionRepository {

    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionOutputMapper transactionOutputMapper;

    @Autowired
    public TransactionRepository(TransactionJpaRepository transactionJpaRepository, TransactionOutputMapper transactionOutputMapper) {
        this.transactionJpaRepository = transactionJpaRepository;
        this.transactionOutputMapper = transactionOutputMapper;
    }

    public TransactionModel save(TransactionModel transactionModel){
        TransactionOutputEntity outputEntity = this.transactionOutputMapper.mapFromModel(transactionModel);
        TransactionOutputEntity transactionOutputEntity = this.transactionJpaRepository.save(outputEntity);
        return this.transactionOutputMapper.mapToModel(transactionOutputEntity);
    }

    public TransactionModel getById(UUID id){
        Optional<TransactionOutputEntity> transactionOutputEntity = this.transactionJpaRepository.findById(id);
        return transactionOutputEntity.map(this.transactionOutputMapper::mapToModel).orElse(null);
    }

    public List<TransactionModel> getAll(String id){
        List<TransactionOutputEntity> outputEntities = this.transactionJpaRepository.findBySender_PhoneNumberOrReceiver_PhoneNumber(id,id);
        return outputEntities.stream().map(this.transactionOutputMapper::mapToModel).collect(Collectors.toList());
    }
}
