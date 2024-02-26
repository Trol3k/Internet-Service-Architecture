package org.example.restaurant.service.api;

import org.example.restaurant.entity.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantService {
    Optional<Restaurant> find(UUID id);

    void create(Restaurant restaurant);

    void delete(UUID id);
}
