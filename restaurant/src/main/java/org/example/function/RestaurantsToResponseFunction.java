package org.example.function;

import org.example.dto.GetRestaurantsResponse;
import org.example.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class RestaurantsToResponseFunction implements Function<List<Restaurant>, GetRestaurantsResponse> {

    @Override
    public GetRestaurantsResponse apply(List<Restaurant> entities) {
        return GetRestaurantsResponse.builder()
                .restaurants(entities.stream()
                        .map(restaurant -> GetRestaurantsResponse.Restaurant.builder()
                                .id(restaurant.getId())
                                .name(restaurant.getName())
                                .build())
                        .toList())
                .build();
    }
}
