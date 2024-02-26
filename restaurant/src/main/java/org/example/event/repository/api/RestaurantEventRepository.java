package org.example.event.repository.api;

import java.util.UUID;

public interface RestaurantEventRepository {
    void delete(UUID id);
    void create(UUID id);
}
