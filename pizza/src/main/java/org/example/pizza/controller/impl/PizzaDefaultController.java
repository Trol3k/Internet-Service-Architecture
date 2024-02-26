package org.example.pizza.controller.impl;

import org.example.restaurant.service.api.RestaurantService;
import org.example.pizza.controller.api.PizzaController;
import org.example.pizza.dto.GetPizzaResponse;
import org.example.pizza.dto.GetPizzasResponse;
import org.example.pizza.dto.PutPizzaRequest;
import org.example.pizza.function.PizzaToResponseFunction;
import org.example.pizza.function.PizzasToResponseFunction;
import org.example.pizza.function.RequestToPizzaFunction;
import org.example.pizza.service.api.PizzaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.logging.Level;

@RestController
@Log
public class PizzaDefaultController implements PizzaController {
    private final PizzaService service;

    private final RestaurantService restaurantService;

    private final PizzaToResponseFunction PizzaToResponse;

    private final PizzasToResponseFunction PizzasToResponse;

    private final RequestToPizzaFunction requestToPizza;

    @Autowired
    public PizzaDefaultController(
            RestaurantService restaurantService,
            PizzaService service,
            PizzaToResponseFunction PizzaToResponse,
            PizzasToResponseFunction PizzasToResponse,
            RequestToPizzaFunction requestToPizza
    ) {
        this.restaurantService = restaurantService;
        this.service = service;
        this.PizzaToResponse = PizzaToResponse;
        this.PizzasToResponse = PizzasToResponse;
        this.requestToPizza = requestToPizza;
    }

    @Override
    public GetPizzasResponse getPizzas() {
        return PizzasToResponse.apply(service.findAll());
    }

    @Override
    public GetPizzasResponse getRestaurantPizzas(UUID restaurantId) {
        return service.findAllByRestaurant(restaurantId)
                .map(PizzasToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetPizzaResponse getPizza(UUID id) {
        return service.find(id)
                .map(PizzaToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putPizza(UUID id, PutPizzaRequest request) {
        restaurantService.find(request.getRestaurant())
                .ifPresentOrElse(
                        Pizza -> service.create(requestToPizza.apply(id, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void deletePizza(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        Pizza -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
