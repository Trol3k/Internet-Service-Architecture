import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pizzas} from "../model/pizzas";
import {PizzaDetails} from "../model/pizza-details";
import {PizzaForm} from "../model/pizza-form";

@Injectable({
    providedIn: 'root'
})
export class PizzaService {

    constructor(private http: HttpClient) {
    }

    getPizzasFromRestaurant(uuid: string): Observable<Pizzas> {
        return this.http.get<Pizzas>('/api/restaurants/' + uuid + '/pizzas')
    }

    getPizza(uuid: string): Observable<PizzaDetails> {
        return this.http.get<PizzaDetails>('/api/pizzas/' + uuid);
    }

    deletePizza(uuid: string): Observable<any> {
        return this.http.delete('/api/pizzas/' + uuid);
    }

    putPizza(uuid: string, request: PizzaForm): Observable<any> {
        return this.http.put('/api/pizzas/' + uuid, request)
    }
}
