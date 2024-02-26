package org.example.pizza.repository.api;

import org.example.pizza.entity.Pizza;
import org.example.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, UUID> {
    List<Pizza> findAllByRestaurant(Restaurant restaurant);
}
