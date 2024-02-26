package org.example.pizza.function;


import org.example.pizza.dto.PatchPizzaRequest;
import org.example.pizza.entity.Pizza;
import org.springframework.stereotype.Component;


import java.util.function.BiFunction;

@Component
public class UpdatePizzaWithRequestFunction implements BiFunction<Pizza, PatchPizzaRequest, Pizza> {

    @Override
    public Pizza apply(Pizza entity, PatchPizzaRequest request) {
        return Pizza.builder()
                .id(entity.getId())
                .name(request.getName())
                .diameter(request.getDiameter())
                .cost(request.getCost())
                .restaurant(entity.getRestaurant())
                .build();
    }
}
