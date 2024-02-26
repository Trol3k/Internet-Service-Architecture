package org.example.pizza.function;

import org.example.pizza.entity.Pizza;
import org.example.pizza.dto.GetPizzasResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
public class PizzasToResponseFunction implements Function<List<Pizza>, GetPizzasResponse> {

    @Override
    public GetPizzasResponse apply(List<Pizza> entities) {
        return GetPizzasResponse.builder()
                .pizzas(entities.stream()
                        .map(pizza -> GetPizzasResponse.Pizza.builder()
                                .id(pizza.getId())
                                .name(pizza.getName())
                                .build())
                        .toList())
                .build();
    }

}
