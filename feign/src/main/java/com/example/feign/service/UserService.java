package com.example.feign.service;

import com.example.feign.client.ApiClient;
import com.example.feign.domain.User;
import com.example.feign.model.response.UserGetDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final ApiClient client;

    public UserService(@Qualifier("apiClientService") ApiClient client) {
        this.client = client;
    }

    public List<User> getAllUser(){
        return client.getAllUser();
    }

    public User getUserById(UUID id){
        return client.getUserById(id);
    }

    public List<UserGetDto> getAllUserDto(){
        return client.getAllUserDto();
    }
}
