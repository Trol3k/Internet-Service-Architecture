import {Component, OnInit} from '@angular/core';
import {PizzaDetails} from "../../model/pizza-details";
import {PizzaService} from "../../service/pizza.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-pizza-view',
  templateUrl: './pizza-view.component.html',
  styleUrls: ['./pizza-view.component.css']
})
export class PizzaViewComponent implements OnInit {
  pizza: PizzaDetails | undefined;

  constructor(private service: PizzaService, private route:ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getPizza(params['uuid'])
        .subscribe(pizza => this.pizza = pizza)
    });
  }

}
