package com.example.cybsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.cybsec.entity.User;
import com.example.cybsec.service.UserService;

@Configuration
public class UserDetailsServiceConfig {

    private final UserService userService;

    public UserDetailsServiceConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles("USER") // Assign a role; can be customized based on your requirements
                    .build();
        };
    }

}
