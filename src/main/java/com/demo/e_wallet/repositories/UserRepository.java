package com.demo.e_wallet.repositories;

import com.demo.e_wallet.entities.output.UserOutputEntity;
import com.demo.e_wallet.mappers.output.UserOutputMapper;
import com.demo.e_wallet.models.UserModel;
import com.demo.e_wallet.repositories.JpaRepository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserOutputMapper userOutputMapper;

    @Autowired
    public UserRepository(UserJpaRepository userJpaRepository, UserOutputMapper userOutputMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userOutputMapper = userOutputMapper;
    }

    public UserModel save(UserModel userModel){
        UserOutputEntity userOutputEntity = this.userOutputMapper.mapFromModel(userModel);
        UserOutputEntity savedOutputEntity = this.userJpaRepository.save(userOutputEntity);
        return this.userOutputMapper.mapToModel(savedOutputEntity);
    }

    public boolean delete(long id){
        if(this.userJpaRepository.existsById(id)){
            this.userJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserModel findById(long id){
        Optional<UserOutputEntity> userOutputEntity = this.userJpaRepository.findById(id);
        return userOutputEntity.map(this.userOutputMapper::mapToModel).orElse(null);
    }

    public UserModel findUserByPhoneNumber(String phoneNumber){
        Optional<UserOutputEntity> userOutputEntity = this.userJpaRepository.findByPhoneNumber(phoneNumber);
        return userOutputEntity.map(this.userOutputMapper::mapToModel).orElse(null);
    }
}
