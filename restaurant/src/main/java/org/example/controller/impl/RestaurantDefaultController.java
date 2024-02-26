package org.example.controller.impl;

import org.example.controller.api.RestaurantController;
import org.example.dto.GetRestaurantResponse;
import org.example.dto.GetRestaurantsResponse;
import org.example.dto.PutRestaurantRequest;
import org.example.function.RequestToRestaurantFunction;
import org.example.function.RestaurantToResponseFunction;
import org.example.function.RestaurantsToResponseFunction;
import org.example.service.api.RestaurantService;
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

    private final RequestToRestaurantFunction RequestToRestaurant;
    private final RestaurantToResponseFunction RestaurantToResponse;

    private final RestaurantsToResponseFunction RestaurantsToResponse;

    @Autowired
    public RestaurantDefaultController(
            RestaurantService service,
            RequestToRestaurantFunction RequestToRestaurant,
            RestaurantToResponseFunction RestaurantToResponse,
            RestaurantsToResponseFunction RestaurantsToResponse
    ) {
        this.service = service;
        this.RequestToRestaurant = RequestToRestaurant;
        this.RestaurantToResponse = RestaurantToResponse;
        this.RestaurantsToResponse = RestaurantsToResponse;
    }

    @Override
    public GetRestaurantsResponse getRestaurants() {
        return RestaurantsToResponse.apply(service.findAll());
    }

    @Override
    public GetRestaurantResponse getRestaurant(UUID id) {
        return service.find(id).map(RestaurantToResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putRestaurant(UUID id, PutRestaurantRequest request) {
        service.create(RequestToRestaurant.apply(id, request));
    }

    @Override
    public void deleteRestaurant(UUID id) {
        service.find(id).ifPresentOrElse(Restaurant -> service.delete(id), () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }


}
