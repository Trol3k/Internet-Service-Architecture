package org.example.service.imp;

import org.example.entity.Restaurant;
import org.example.event.repository.api.RestaurantEventRepository;
import org.example.service.api.RestaurantService;
import org.example.repository.api.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantDefaultService implements RestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantEventRepository eventRepository;

    @Autowired
    public RestaurantDefaultService(RestaurantRepository repository, RestaurantEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Restaurant> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Restaurant restaurant) {
        repository.save(restaurant);
        eventRepository.create(restaurant.getId());
    }

    @Override
    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

}
