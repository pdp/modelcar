import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import {CarCreationComponent} from './components/carcreation-component/carcreation.component';
import {NavigationComponent} from './components/navigation-component/navigation.component';
import {APP_ROUTES} from './common/Routes';
import { CarsComponent } from './components/cars/cars.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CarService} from './service/car.service';
import {HttpModule} from '@angular/http';
import { CardialogComponent } from './components/cardialog/cardialog.component';
import {AutoCompleteModule, ButtonModule, CheckboxModule, DialogModule, DropdownModule, InputTextModule} from 'primeng/primeng';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    CarCreationComponent,
    NavigationComponent,
    CarsComponent,
    CardialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DialogModule,
    BrowserAnimationsModule,
    ButtonModule,
    AutoCompleteModule,
    ReactiveFormsModule,
    InputTextModule,
    DropdownModule,
    CheckboxModule,
    RouterModule.forRoot(
      APP_ROUTES
    )
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
