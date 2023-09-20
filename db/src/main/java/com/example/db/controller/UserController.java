package com.example.db.controller;

import com.example.db.domain.User;
import com.example.db.model.request.AddUserDto;
import com.example.db.model.request.UserUpdateDto;
import com.example.db.model.response.UserGetDto;
import com.example.db.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserGetDto> addUser(@RequestBody AddUserDto userDto){
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUserNotDto(){
        return new ResponseEntity<>(userService.getAllUserNotDto(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<UserGetDto>> getAllUserDto(){
        return new ResponseEntity<>(userService.getAllUserDto(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@RequestBody UserUpdateDto userUpdateDto, @PathVariable UUID id){
        return new ResponseEntity<>(userService.updateUserById(userUpdateDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        return new ResponseEntity<>(userService.deleteUserById(id),HttpStatus.OK);
    }

}
