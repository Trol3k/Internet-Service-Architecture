package org.example.function;


import org.example.dto.GetRestaurantResponse;
import org.example.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RestaurantToResponseFunction implements Function<Restaurant, GetRestaurantResponse> {

    @Override
    public GetRestaurantResponse apply(Restaurant entity) {
        return GetRestaurantResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .build();
    }
}
