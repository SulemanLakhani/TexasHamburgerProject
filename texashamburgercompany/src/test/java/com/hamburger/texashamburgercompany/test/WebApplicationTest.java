package com.hamburger.texashamburgercompany.test;

import com.hamburger.texashamburgercompany.controller.RestaurantController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class WebApplicationTest {

    @Autowired
    private RestaurantController restaurantController;

    @Test
    public void contextLoads() {
        assertThat(restaurantController).isNotNull();

    }
}
