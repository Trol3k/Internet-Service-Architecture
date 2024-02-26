import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PizzaEditComponent} from './pizza/view/pizza-edit/pizza-edit.component';
import {PizzaViewComponent} from './pizza/view/pizza-view/pizza-view.component';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {RestaurantEditComponent} from './restaurant/view/restaurant-edit/restaurant-edit.component';
import {HttpClientModule} from "@angular/common/http";
import {MainComponent} from "./component/main/main.component";
import {FormsModule} from "@angular/forms";
import {PizzaService} from "./pizza/service/pizza.service";
import {RestaurantService} from "./restaurant/service/restaurant.service";
import {RestaurantViewComponent} from "./restaurant/view/restaurant-view/restaurant-view.component";
import {RestaurantListComponent} from "./restaurant/view/restaurant-list/restaurant-list.component";
import { PizzaAddComponent } from './pizza/view/pizza-add/pizza-add.component';
import { RestaurantAddComponent } from './restaurant/view/restaurant-add/restaurant-add.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    FooterComponent,
    RestaurantListComponent,
    RestaurantViewComponent,
    PizzaEditComponent,
    PizzaViewComponent,
    RestaurantEditComponent,
    PizzaAddComponent,
    RestaurantAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PizzaService,
    RestaurantService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
