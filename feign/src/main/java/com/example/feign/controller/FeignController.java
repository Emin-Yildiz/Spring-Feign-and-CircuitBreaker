package com.example.feign.controller;

import com.example.feign.domain.User;
import com.example.feign.model.response.UserGetDto;
import com.example.feign.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/feign")
public class FeignController {

    private final UserService userService;

    public FeignController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUserNotDto() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<UserGetDto>> getAllUserDto(){
        return new ResponseEntity<>(userService.getAllUserDto(),HttpStatus.OK);
    }
}
