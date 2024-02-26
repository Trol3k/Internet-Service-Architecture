package org.example.controller.api;

import org.example.dto.GetRestaurantResponse;
import org.example.dto.GetRestaurantsResponse;
import org.example.dto.PutRestaurantRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface RestaurantController {

    @GetMapping("api/restaurants")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetRestaurantsResponse getRestaurants();

    @GetMapping("/api/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetRestaurantResponse getRestaurant(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/restaurants/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putRestaurant(@PathVariable("id")
                  UUID id,
                  @RequestBody
                  PutRestaurantRequest request
    );

    @DeleteMapping("/api/restaurants/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRestaurant(
            @PathVariable("id")
            UUID id
    );

}
