package org.example.pizza.function;

import org.example.pizza.entity.Pizza;
import org.example.restaurant.entity.Restaurant;
import org.example.pizza.dto.PutPizzaRequest;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToPizzaFunction implements BiFunction<UUID, PutPizzaRequest, Pizza> {

    @Override
    public Pizza apply(UUID id, PutPizzaRequest request) {
        return Pizza.builder()
                .id(id)
                .name(request.getName())
                .diameter(request.getDiameter())
                .cost(request.getCost())
                .restaurant(Restaurant.builder()
                        .id(request.getRestaurant())
                        .build())
                .build();
    }
}
