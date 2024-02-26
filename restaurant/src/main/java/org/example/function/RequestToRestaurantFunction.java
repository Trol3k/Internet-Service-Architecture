package org.example.function;

import org.example.entity.Restaurant;
import org.example.dto.PutRestaurantRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToRestaurantFunction implements BiFunction<UUID, PutRestaurantRequest, Restaurant> {

    @Override
    public Restaurant apply(UUID id, PutRestaurantRequest request) {
        return Restaurant.builder()
                .id(id)
                .name(request.getName())
                .location(request.getLocation())
                .build();
    }
}
