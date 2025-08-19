package com.demo.e_wallet.adapters;

import com.demo.e_wallet.common.CommonAdapter;
import com.demo.e_wallet.entities.input.UserInputEntity;
import com.demo.e_wallet.mappers.input.UserInputMapper;
import com.demo.e_wallet.models.UserModel;
import com.demo.e_wallet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAdapter implements CommonAdapter<UserInputEntity, UserModel> {

    private final UserService userService;
    private final UserInputMapper userInputMapper;

    @Autowired
    public UserAdapter(UserService userService, UserInputMapper userInputMapper) {
        this.userService = userService;
        this.userInputMapper = userInputMapper;
    }

    @Override
    public UserModel save(UserInputEntity userInputEntity) {
        return this.userService.save(this.userInputMapper.mapToModel(userInputEntity));
    }

    @Override
    public UserModel update(long id,UserInputEntity userInputEntity) {
        return this.userService.update(id,this.userInputMapper.mapToModel(userInputEntity));
    }

    @Override
    public List<UserModel> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(long id) {
        try{
            return this.userService.delete(id);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserModel getById(long id) {
        return this.userService.getById(id);
    }

}
