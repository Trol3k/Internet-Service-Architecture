import {Component, OnInit} from '@angular/core';
import {PizzaService} from "../../service/pizza.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RestaurantService} from "../../../restaurant/service/restaurant.service";
import {Restaurant} from "../../../restaurant/model/restaurant";

@Component({
    selector: 'app-pizza-add',
    templateUrl: './pizza-add.component.html',
    styleUrls: ['./pizza-add.component.css']
})
export class PizzaAddComponent implements OnInit {
    uuid: string | undefined;
    pizza: {
        name: string,
        diameter: number,
        cost: number,
        restaurant: string
    } | undefined;
    restaurant: Restaurant | undefined

    constructor(
        private restaurantService: RestaurantService,
        private pizzaService: PizzaService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.restaurantService.getRestaurant(params['uuid'])
                .subscribe(restaurant => this.restaurant = restaurant)

            this.uuid = crypto.randomUUID();
            this.pizza = {
                name: "",
                diameter: 0,
                cost: 0,
                restaurant: params['uuid']
            }
        });
    }

    onSubmit(): void {
        this.pizzaService.putPizza(this.uuid!, this.pizza!)
            .subscribe(() => this.router.navigate((['/restaurants/' + this.restaurant?.id])));

    }
}
