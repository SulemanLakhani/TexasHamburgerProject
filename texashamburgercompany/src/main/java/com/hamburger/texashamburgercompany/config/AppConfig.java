package com.hamburger.texashamburgercompany.config;

import com.hamburger.texashamburgercompany.model.Users;
import com.hamburger.texashamburgercompany.service.RestaurantLocationService;
import com.hamburger.texashamburgercompany.service.UserService;
import com.hamburger.texashamburgercompany.service.impl.RestaurantLocationServiceImpl;
import com.hamburger.texashamburgercompany.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public RestaurantLocationService restaurantLocationService(){
        return new RestaurantLocationServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
