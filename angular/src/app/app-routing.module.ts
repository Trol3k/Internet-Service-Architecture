import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RestaurantListComponent} from "./restaurant/view/restaurant-list/restaurant-list.component";
import {PizzaViewComponent} from "./pizza/view/pizza-view/pizza-view.component";
import {RestaurantViewComponent} from "./restaurant/view/restaurant-view/restaurant-view.component";
import {RestaurantEditComponent} from "./restaurant/view/restaurant-edit/restaurant-edit.component";
import {PizzaEditComponent} from "./pizza/view/pizza-edit/pizza-edit.component";
import {PizzaAddComponent} from "./pizza/view/pizza-add/pizza-add.component";
import {RestaurantAddComponent} from "./restaurant/view/restaurant-add/restaurant-add.component";

const routes: Routes = [
    {
        path: "",
        redirectTo: "restaurants",
        pathMatch: 'full'
    },
    {
        component: RestaurantListComponent,
        path: "restaurants"
    },
    {
        component: RestaurantAddComponent,
        path: "restaurants/add"
    },
    {
        component: RestaurantViewComponent,
        path: "restaurants/:uuid"
    },
    {
        component: RestaurantEditComponent,
        path: "restaurants/:uuid/edit"
    },
    {
        component: PizzaAddComponent,
        path: "restaurants/:uuid/add"
    },
    {
        component: PizzaViewComponent,
        path: "pizzas/:uuid"
    },
    {
        component: PizzaEditComponent,
        path: "pizzas/:uuid/edit"
    },

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
