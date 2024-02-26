package org.example.pizza.service.api;

import org.example.pizza.entity.Pizza;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PizzaService {
    Optional<Pizza> find(UUID id);

    List<Pizza> findAll();

    void create(Pizza pizza);

    void update(Pizza pizza);

    void delete(UUID id);

    Optional<List<Pizza>> findAllByRestaurant(UUID restaurantId);
}
