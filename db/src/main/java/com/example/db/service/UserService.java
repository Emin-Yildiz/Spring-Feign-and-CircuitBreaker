package com.example.db.service;

import com.example.db.domain.User;
import com.example.db.model.request.AddUserDto;
import com.example.db.model.request.UserUpdateDto;
import com.example.db.model.response.UserGetDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserGetDto addUser(AddUserDto userDto);
    List<User> getAllUserNotDto();
    List<UserGetDto> getAllUserDto();
    User getUserById(UUID id);
    UserGetDto getUserByIdDto(UUID id);
    String updateUserById(UserUpdateDto updateDto, UUID id);
    String deleteUserById(UUID id);
}
