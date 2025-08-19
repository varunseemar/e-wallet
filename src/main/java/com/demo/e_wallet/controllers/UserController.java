package com.demo.e_wallet.controllers;

import com.demo.e_wallet.adapters.UserAdapter;
import com.demo.e_wallet.entities.input.UserInputEntity;
import com.demo.e_wallet.exceptions.UserNotFoundException;
import com.demo.e_wallet.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserAdapter userAdapter;

    @Autowired
    public UserController(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserInputEntity userInputEntity){
        UserModel userModel = this.userAdapter.save(userInputEntity);
        if(userModel == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not able to create User.");
        }
        return ResponseEntity.ok(userModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@Valid @PathVariable long id){
        UserModel userModel = this.userAdapter.getById(id);
        if(userModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not able to get User with id : " + id);
        }
        return ResponseEntity.ok(userModel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable long id,@Valid @RequestBody UserInputEntity userInputEntity){
        UserModel userModel = this.userAdapter.update(id,userInputEntity);
        if(userModel == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not able to update User.");
        }
        return ResponseEntity.ok(userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id){
        try{
            this.userAdapter.delete(id);
            return ResponseEntity.ok().body("User Deleted Successfully");
        }
        catch(UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
