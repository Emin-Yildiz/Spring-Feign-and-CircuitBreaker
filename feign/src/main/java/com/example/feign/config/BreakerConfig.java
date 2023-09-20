package com.example.feign.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BreakerConfig {

    @Bean
    public CircuitBreakerConfig config() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(2)
                .build();
    }
}
