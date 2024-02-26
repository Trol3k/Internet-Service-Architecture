package org.example.pizza.function;

import org.example.pizza.entity.Pizza;
import org.example.pizza.dto.GetPizzaResponse;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PizzaToResponseFunction implements Function<Pizza, GetPizzaResponse> {

    @Override
    public GetPizzaResponse apply(Pizza entity) {
        return GetPizzaResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .diameter(entity.getDiameter())
                .cost(entity.getCost())
                .restaurant(GetPizzaResponse.Restaurant.builder()
                        .id(entity.getRestaurant().getId())
                        .build())
                .build();
    }
}
