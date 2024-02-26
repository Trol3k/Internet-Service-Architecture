package org.example.pizza.service.imp;

import org.example.pizza.entity.Pizza;
import org.example.pizza.service.api.PizzaService;
import org.example.pizza.repository.api.PizzaRepository;
import org.example.restaurant.repository.api.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PizzaDefaultService implements PizzaService {


    private final PizzaRepository repository;

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public PizzaDefaultService(
            PizzaRepository repository,
            RestaurantRepository restaurantRepository
    ) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Pizza> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Pizza>> findAllByRestaurant(UUID RestaurantId) {
        return restaurantRepository.findById(RestaurantId)
                .map(repository::findAllByRestaurant);
    }

    @Override
    public void create(Pizza Pizza) {
        repository.save(Pizza);
    }

    @Override
    public void update(Pizza Pizza) {
        repository.save(Pizza);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
