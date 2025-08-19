package com.demo.e_wallet.controllers;

import com.demo.e_wallet.adapters.TransactionAdapter;
import com.demo.e_wallet.entities.input.TransactionInputEntity;
import com.demo.e_wallet.models.TransactionModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionAdapter transactionAdapter;

    @Autowired
    public TransactionController(TransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @PostMapping("/send")
    public ResponseEntity<?> addTransaction(@Valid @RequestBody TransactionInputEntity transactionInputEntity){
        TransactionModel transactionModel = this.transactionAdapter.save(transactionInputEntity);
        if(transactionModel == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not able to create Transaction.");
        }
        return ResponseEntity.ok(transactionModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable UUID id){
        TransactionModel transactionModel = this.transactionAdapter.getById(id);
        if(transactionModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not able to get Transaction with id : " + id);
        }
        return ResponseEntity.ok(transactionModel);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<?> getAllTransactionsForUser(@PathVariable String id){
        List<TransactionModel> transactionModelList = this.transactionAdapter.getAll(id);
        if(transactionModelList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not able to get Transactions for User with id : " + id);
        }
        return ResponseEntity.ok(transactionModelList);
    }
}
