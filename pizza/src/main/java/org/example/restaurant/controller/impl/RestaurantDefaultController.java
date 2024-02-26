package org.example.restaurant.controller.impl;

import org.example.restaurant.controller.api.RestaurantController;
import org.example.restaurant.entity.Restaurant;
import org.example.restaurant.service.api.RestaurantService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class RestaurantDefaultController implements RestaurantController {

    private final RestaurantService service;

    @Autowired
    public RestaurantDefaultController(RestaurantService service) {
        this.service = service;
    }


    @Override
    public void deleteRestaurant(UUID id) {
        service.find(id).ifPresentOrElse(Restaurant -> service.delete(id), () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    @Override
    public void createRestaurant(UUID id) {
        service.create(Restaurant.builder()
                .id(id)
                .build());
    }

}
