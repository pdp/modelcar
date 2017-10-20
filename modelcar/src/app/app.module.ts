import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import {CarCreationComponent} from './components/carcreation-component/carcreation.component';
import {NavigationComponent} from './components/navigation-component/navigation.component';
import {APP_ROUTES} from './common/Routes';
import { CarsComponent } from './components/cars/cars.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CarCreationComponent,
    NavigationComponent,
    CarsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      APP_ROUTES
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
