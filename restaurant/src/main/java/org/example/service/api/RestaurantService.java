package org.example.service.api;

import org.example.entity.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantService {
    Optional<Restaurant> find(UUID id);

    List<Restaurant> findAll();

    void create(Restaurant restaurant);

    void delete(UUID id);
}
