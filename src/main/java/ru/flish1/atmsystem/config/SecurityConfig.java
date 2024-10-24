package ru.flish1.atmsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.flish1.atmsystem.util.HashUtil;

@Configuration
public class SecurityConfig {
    @Value("${spring.security.atm.hash-algorithm}")
    private String algorithm;


    @Bean
    public HashUtil hashUtil(){
        return new HashUtil(algorithm);
    }
}
