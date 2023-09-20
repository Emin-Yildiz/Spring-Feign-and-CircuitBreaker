package com.example.feign.client;

import com.example.feign.domain.User;
import com.example.feign.model.response.UserGetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "db", url = "http://localhost:8080/user")
public interface ApiClient {

    @GetMapping()
    List<User> getAllUser();

    @GetMapping("/{id}")
    User getUserById(@PathVariable UUID id);

    @GetMapping("/dto")
    List<UserGetDto> getAllUserDto();

}
