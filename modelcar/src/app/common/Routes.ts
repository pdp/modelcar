import {Routes} from '@angular/router';
import {CarCreationComponent} from '../components/carcreation-component/carcreation.component';
import {CarsComponent} from '../components/cars/cars.component';


export const APP_ROUTES: Routes = [
  {path: 'newcar', component: CarCreationComponent},
  {path: 'cars', component: CarsComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
]
