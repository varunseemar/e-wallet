package com.demo.e_wallet.repositories.JpaRepository;

import com.demo.e_wallet.entities.output.UserOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserOutputEntity, Long> {

    Optional<UserOutputEntity> findByPhoneNumber(String phoneNumber);
}
