import {Component, OnInit} from '@angular/core';
import {Restaurants} from "../../model/restaurants";
import {RestaurantService} from "../../service/restaurant.service";
import {Restaurant} from "../../model/restaurant";


@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {
  restaurants: Restaurants | undefined;

  constructor(private service: RestaurantService) {
  }

  ngOnInit() {
    this.service.getRestaurants()
      .subscribe(restaurants => this.restaurants = restaurants);
  }

  onDelete(restaurant: Restaurant): void {
    this.service.deleteRestaurant(restaurant.id).subscribe(() => this.ngOnInit());
  }
}
