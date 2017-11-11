import {Injectable} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Car} from '../domain/Car';

@Injectable()
export class ToCarDtoMapper {

  map(car) {
    const newCar = new Car();
    newCar.model = car['model'];
    newCar.itemRef = car['itemRef'];
    newCar.limitedEdition = car['limitedEdition'];
    newCar.boxed = car['boxed'];
    newCar.coupe = car['coupe'];
    newCar.color = car['color'];
    newCar.scale = car['scale'];
    return newCar;
  }

}
