import {Restaurant} from "../../restaurant/model/restaurant";

export interface PizzaDetails {
  id: string;
  name: string;
  diameter: number;
  cost: number;
  restaurant: Restaurant;
}
