import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Restaurants} from "../model/restaurants";
import {RestaurantDetails} from "../model/restaurant-details";
import {RestaurantForm} from "../model/restaurant-form";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient) {
  }

  getRestaurants(): Observable<Restaurants> {
    return this.http.get<Restaurants>('/api/restaurants');
  }

  getRestaurant(uuid: string): Observable<RestaurantDetails> {
    return this.http.get<RestaurantDetails>('/api/restaurants/' + uuid);
  }

  deleteRestaurant(uuid: string): Observable<any> {
    return this.http.delete('/api/restaurants/' + uuid);
  }

  putRestaurant(uuid: string, request: RestaurantForm): Observable<any> {
    return this.http.put('/api/restaurants/' + uuid, request)
  }
}
