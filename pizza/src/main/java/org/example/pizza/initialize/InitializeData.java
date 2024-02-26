package org.example.pizza.initialize;

import org.example.pizza.entity.Pizza;
import org.example.restaurant.entity.Restaurant;
import org.example.pizza.service.api.PizzaService;
import org.example.restaurant.service.api.RestaurantService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final PizzaService pizzaService;
    private final RestaurantService restaurantService;

    @Autowired
    public InitializeData(
            PizzaService pizzaService,
            RestaurantService restaurantService
    ) {
        this.pizzaService = pizzaService;
        this.restaurantService = restaurantService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
                .id(UUID.fromString("35108afd-1c5e-46b4-ae21-7ff2a0fd76fc"))
                .build();

        Restaurant restaurant2 = Restaurant.builder()
                .id(UUID.fromString("7f4994b8-9474-4c30-ae03-0d131f750a34"))
                .build();

        restaurantService.create(restaurant1);
        restaurantService.create(restaurant2);

        Pizza pizza1 = Pizza.builder()
                .id(UUID.fromString("8cf7fa5c-9c19-40d2-8ccc-676784452af2"))
                .name("Capricciosa")
                .diameter(32)
                .cost(35.0)
                .restaurant(restaurant1)
                .build();

        Pizza pizza2 = Pizza.builder()
                .id(UUID.fromString("1b360a2e-5240-465c-b4c4-ee690f16e359"))
                .name("Margharita").diameter(32)
                .cost(30.0)
                .restaurant(restaurant1)
                .build();

        Pizza pizza3 = Pizza.builder()
                .id(UUID.fromString("79309f67-6f11-47c6-abaf-b205bc073493"))
                .name("Capricciosa")
                .diameter(40)
                .cost(44.0)
                .restaurant(restaurant2)
                .build();

        Pizza pizza4 = Pizza.builder()
                .id(UUID.fromString("6ef40acd-de03-4bb0-8562-0833aeb2829f"))
                .name("Hawai")
                .diameter(30)
                .cost(34.0)
                .restaurant(restaurant2)
                .build();


        pizzaService.create(pizza1);
        pizzaService.create(pizza2);
        pizzaService.create(pizza3);
        pizzaService.create(pizza4);
    }
}
