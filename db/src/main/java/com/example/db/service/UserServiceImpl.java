package com.example.db.service;

import com.example.db.domain.User;
import com.example.db.model.request.AddUserDto;
import com.example.db.model.request.UserUpdateDto;
import com.example.db.model.response.UserGetDto;
import com.example.db.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.modelMapper = mapper;
    }

    @Override
    public UserGetDto addUser(AddUserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        return modelMapper.map(userRepository.save(user), UserGetDto.class);
    }

    @Override
    public List<User> getAllUserNotDto() {
        return userRepository.findAll();
    }

    @Override
    public List<UserGetDto> getAllUserDto() {
        List<UserGetDto> list = new ArrayList<>();
        userRepository.findAll().forEach(
                user -> list.add(modelMapper.map(user,UserGetDto.class))
        );
        return list;
    }

    @Override
    public User getUserById(UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    public UserGetDto getUserByIdDto(UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.map(user -> modelMapper.map(user, UserGetDto.class)).orElse(null);
     }

    @Override
    public String updateUserById(UserUpdateDto updateDto, UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            User user = foundUser.get();
            modelMapper.map(updateDto,user);
            userRepository.save(user);
            return "Update success";
        }else
            return "Update failed";
    }

    @Override
    public String deleteUserById(UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            userRepository.delete(foundUser.get());
            return "Delete success";
        }else
            return "Delete failed";
    }
}
