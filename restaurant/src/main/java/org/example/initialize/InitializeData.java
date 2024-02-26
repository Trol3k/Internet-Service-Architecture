package org.example.initialize;

import org.example.entity.Restaurant;
import org.example.service.api.RestaurantService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final RestaurantService restaurantService;

    @Autowired
    public InitializeData(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
                .id(UUID.fromString("35108afd-1c5e-46b4-ae21-7ff2a0fd76fc"))
                .name("Ostro")
                .location("Długie Pobrzeze 15, Gdansk 80-888 Poland")
                .build();

        Restaurant restaurant2 = Restaurant.builder()
                .id(UUID.fromString("7f4994b8-9474-4c30-ae03-0d131f750a34"))
                .name("Casa Del Gusto")
                .location("Szafarnia 11/u15, Gdansk 80-755 Poland")
                .build();

        restaurantService.create(restaurant1);
        restaurantService.create(restaurant2);

    }
}
