package org.example.restaurant.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface RestaurantController {

    @DeleteMapping("/api/restaurants/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRestaurant(
            @PathVariable("id")
            UUID id
    );
    @PutMapping("/api/restaurants/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void createRestaurant(
            @PathVariable("id")
            UUID id
    );
}
