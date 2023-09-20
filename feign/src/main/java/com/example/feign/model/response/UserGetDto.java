package com.example.feign.model.response;

import java.util.UUID;

public class UserGetDto {

    private String userName;
    private String email;

    public UserGetDto(UUID id, String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public UserGetDto(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
