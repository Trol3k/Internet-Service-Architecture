import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../service/restaurant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-restaurant-add',
  templateUrl: './restaurant-add.component.html',
  styleUrls: ['./restaurant-add.component.css']
})
export class RestaurantAddComponent implements OnInit {
  uuid: string | undefined;
  restaurant: { name: string, location: string } | undefined;

  constructor(
    private restaurantService: RestaurantService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.uuid = crypto.randomUUID();
    this.restaurant = {
      name: "",
      location: ""
    }
  }

  onSubmit(): void {
    this.restaurantService.putRestaurant(this.uuid!, this.restaurant!)
      .subscribe(() => this.router.navigate((['/restaurants'])));
  }
}
