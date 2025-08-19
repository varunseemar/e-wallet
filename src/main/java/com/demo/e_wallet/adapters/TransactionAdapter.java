package com.demo.e_wallet.adapters;

import com.demo.e_wallet.common.CommonAdapter;
import com.demo.e_wallet.entities.input.TransactionInputEntity;
import com.demo.e_wallet.mappers.input.TransactionInputMapper;
import com.demo.e_wallet.models.TransactionModel;
import com.demo.e_wallet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionAdapter implements CommonAdapter<TransactionInputEntity, TransactionModel> {

    private final TransactionService transactionService;
    private final TransactionInputMapper transactionInputMapper;

    @Autowired
    public TransactionAdapter(TransactionService transactionService, TransactionInputMapper transactionInputMapper) {
        this.transactionService = transactionService;
        this.transactionInputMapper = transactionInputMapper;
    }

    @Override
    public TransactionModel save(TransactionInputEntity transactionInputEntity) {
        return this.transactionService.save(this.transactionInputMapper.mapToModel(transactionInputEntity));
    }

    public TransactionModel getById(UUID id) {
        return this.transactionService.getById(id);
    }

    public List<TransactionModel> getAll(String id) {
        return this.transactionService.getAll(id);
    }

    @Override
    public TransactionModel update(long id,TransactionInputEntity transactionInputEntity) {
        return null;
    }

    @Override
    public List<TransactionModel> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(long id) {

        return false;
    }

    @Override
    public TransactionModel getById(long id) {
        return null;
    }
}
