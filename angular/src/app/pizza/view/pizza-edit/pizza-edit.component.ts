import {Component, OnInit} from '@angular/core';
import {PizzaForm} from "../../model/pizza-form";
import {PizzaService} from "../../service/pizza.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-pizza-edit',
  templateUrl: './pizza-edit.component.html',
  styleUrls: ['./pizza-edit.component.css']
})
export class PizzaEditComponent implements OnInit {
  uuid: string | undefined;
  pizza: PizzaForm | undefined;
  original: PizzaForm | undefined

  constructor(
    private pizzaService: PizzaService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.pizzaService.getPizza(params['uuid'])
        .subscribe(pizza => {
          this.uuid = pizza.id;
          this.pizza = {
            name: pizza.name,
            diameter: pizza.diameter,
            cost: pizza.cost,
            restaurant: pizza.restaurant.id
          };
          this.original = {...this.pizza};
        });
    });
  }

  onSubmit(): void {
    this.pizzaService.putPizza(this.uuid!, this.pizza!)
      .subscribe(() => this.router.navigate((['/restaurants/' + this.pizza?.restaurant])));

  }
}
