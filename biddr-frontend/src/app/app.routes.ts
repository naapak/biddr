import {Routes} from '@angular/router';
import {HomeComponent} from './home';
import {AboutComponent} from './about';
import {NoContentComponent} from './no-content';
import {ProductsComponent} from "./components/products/products.component";
import {OrdersComponent} from "./components/orders/orders.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {AuthenticationComponent} from "./components/authentication/authentication.component";

export const ROUTES: Routes = [
  {path: '', component: ProductsComponent},
  {path: 'login', component: AuthenticationComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'orders', component: OrdersComponent},
  {path: 'profile', component: ProfileComponent},
  {path: '**', component: ProductsComponent},
];
