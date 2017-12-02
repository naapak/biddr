import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {PreloadAllModules, RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {environment} from 'environments/environment';
import {ROUTES} from './app.routes';
import {AppComponent} from './app.component';
import {AuthenticationComponent} from "./components/authentication/authentication.component";
import {HeaderComponent} from "./components/header/header.component";
import {OrdersComponent} from "./components/orders/orders.component";
import {ProductsComponent} from "./components/products/products.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {SidenavComponent} from "./components/sidenav/sidenav.component";
import '../styles/styles.scss';
import '../styles/headings.css';
import {MatButtonModule, MatFormFieldModule, MatInputModule, MatPaginatorModule, MatSidenavModule, MatTableModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";

type StoreType = {
  restoreInputValues: () => void,
  disposeOldHosts: () => void
};

/**
 * `AppModule` is the main entry point into Angular2's bootstraping process
 */
@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HeaderComponent,
    OrdersComponent,
    ProductsComponent,
    ProfileComponent,
    SidenavComponent,
  ],
  /**
   * Import Angular's modules.
   */
  imports: [
    BrowserModule,
    BrowserAnimationsModule,

    MatButtonModule,
    MatSidenavModule,
    MatTableModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatInputModule,

    FormsModule,
    FlexLayoutModule,

    HttpModule,
    RouterModule.forRoot(ROUTES, {
      useHash: Boolean(history.pushState) === false,
      preloadingStrategy: PreloadAllModules
    }),
  ],
  /**
   * Expose our Services and Providers into Angular's dependency injection.
   */
  providers: [
    environment.ENV_PROVIDERS,
  ]
})
export class AppModule {
}
