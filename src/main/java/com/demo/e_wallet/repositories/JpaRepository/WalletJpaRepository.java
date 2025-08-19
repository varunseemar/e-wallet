package com.demo.e_wallet.repositories.JpaRepository;

import com.demo.e_wallet.entities.output.WalletOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletJpaRepository extends JpaRepository<WalletOutputEntity,Long> {
}
