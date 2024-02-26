package org.example.pizza.controller.api;

import org.example.pizza.dto.GetPizzaResponse;
import org.example.pizza.dto.GetPizzasResponse;
import org.example.pizza.dto.PutPizzaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

public interface PizzaController {
    @GetMapping("api/pizzas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPizzasResponse getPizzas();

    @GetMapping("/api/restaurants/{restaurantId}/pizzas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPizzasResponse getRestaurantPizzas(
            @PathVariable("restaurantId")
            UUID restaurantId
    );

    @GetMapping("/api/pizzas/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPizzaResponse getPizza(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/pizzas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPizza(@PathVariable("id")
                  UUID id,
                  @RequestBody
                  PutPizzaRequest request
    );

    @DeleteMapping("/api/pizzas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePizza(
            @PathVariable("id")
            UUID id
    );
}
