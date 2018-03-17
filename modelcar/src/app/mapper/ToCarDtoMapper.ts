import {Injectable} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {CarDto} from '../domain/CarDto';

@Injectable()
export class ToCarDtoMapper {

  map(car) {
    const newCar = new CarDto();
    newCar.modelDto = car['model'];
    newCar.modelDto.brandDto = car['brand'];
    newCar.itemRef = car['itemRef'];
    newCar.limitedEdition = car['limitedEdition'];
    newCar.boxed = car['boxed'];
    newCar.coupe = car['coupe'];
    newCar.colorDto = car['color'];
    newCar.scale = car['scale'];
    return newCar;
  }

}
