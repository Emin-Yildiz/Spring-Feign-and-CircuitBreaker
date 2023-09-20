package com.example.feign.client;

import com.example.feign.domain.User;
import com.example.feign.model.response.UserGetDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ApiClientService implements ApiClient {

    private final ApiClient apiClient;

    public ApiClientService(@Qualifier("com.example.feign.client.ApiClient") ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    @CircuitBreaker(name = "userServiceId", fallbackMethod = "orderFallback")
    public User getUserById(UUID id) {
        return apiClient.getUserById(id);
    }

    @Override
    @CircuitBreaker(name = "userService", fallbackMethod = "orderFallback_2")
    public List<User> getAllUser(){
        return apiClient.getAllUser();
    }

    @Override
    @CircuitBreaker(name = "userServiceDto", fallbackMethod = "orderFallback_3")
    public List<UserGetDto> getAllUserDto() {
        return apiClient.getAllUserDto();
    }

    public User orderFallback(UUID id, Exception e) {
        return new User();
    }

    public List<User> orderFallback_2(Exception e) {
        return new ArrayList<>();
    }

    public List<UserGetDto> orderFallback_3(Exception e) {
        return new ArrayList<>();
    }
}
