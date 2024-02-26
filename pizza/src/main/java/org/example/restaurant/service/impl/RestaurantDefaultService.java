package org.example.restaurant.service.impl;

import org.example.restaurant.entity.Restaurant;
import org.example.restaurant.service.api.RestaurantService;
import org.example.restaurant.repository.api.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantDefaultService implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantDefaultService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Restaurant> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Restaurant Restaurant) {
        repository.save(Restaurant);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
