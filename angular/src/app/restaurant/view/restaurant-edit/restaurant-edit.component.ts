import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../service/restaurant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RestaurantForm} from "../../model/restaurant-form";

@Component({
  selector: 'app-restaurant-edit',
  templateUrl: './restaurant-edit.component.html',
  styleUrls: ['./restaurant-edit.component.css']
})
export class RestaurantEditComponent implements OnInit {
  uuid: string | undefined;
  restaurant: RestaurantForm | undefined;
  original: RestaurantForm | undefined

  constructor(
    private restaurantService: RestaurantService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.restaurantService.getRestaurant(params['uuid'])
        .subscribe(restaurant => {
          this.uuid = restaurant.id;
          this.restaurant = {
            name: restaurant.name,
            location: restaurant.location
          };
          this.original = {...this.restaurant};
        });
    });
  }

  onSubmit(): void {
    this.restaurantService.putRestaurant(this.uuid!, this.restaurant!)
      .subscribe(() => this.router.navigate((['/restaurants'])));
  }
}
