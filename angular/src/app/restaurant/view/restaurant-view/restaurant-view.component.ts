import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RestaurantDetails} from "../../model/restaurant-details";
import {RestaurantService} from "../../service/restaurant.service";
import {Pizzas} from "../../../pizza/model/pizzas";
import {PizzaService} from "../../../pizza/service/pizza.service";
import {Pizza} from "../../../pizza/model/pizza";
import {PizzaForm} from "../../../pizza/model/pizza-form";

@Component({
    selector: 'app-restaurant-view',
    templateUrl: './restaurant-view.component.html',
    styleUrls: ['./restaurant-view.component.css']
})
export class RestaurantViewComponent implements OnInit {
    restaurant: RestaurantDetails | undefined;
    pizzas: Pizzas | undefined;
    pizza: Pizza | undefined

    constructor(private restaurantService: RestaurantService, private pizzaService: PizzaService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.restaurantService.getRestaurant(params['uuid'])
                .subscribe(restaurant => this.restaurant = restaurant)
            this.pizzaService.getPizzasFromRestaurant(params['uuid'])
                .subscribe(pizzas => this.pizzas = pizzas)
        });
    }

    onDelete(pizza: Pizza): void {
        this.pizzaService.deletePizza(pizza.id).subscribe(() => this.ngOnInit());
    }
}
