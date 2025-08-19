package com.demo.e_wallet.repositories.JpaRepository;

import com.demo.e_wallet.entities.output.TransactionOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionOutputEntity, UUID> {
    List<TransactionOutputEntity> findBySender_PhoneNumberOrReceiver_PhoneNumber(String phoneNumber, String phoneNumber1);
}
