import {Component, EventEmitter, OnInit, Output, ViewEncapsulation} from '@angular/core';
import {CarDto} from '../../domain/CarDto';
import {CarService} from '../../service/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: CarDto[] = [];

  car: CarDto;

  openDialog: boolean;

  constructor(private carService: CarService) { }

  ngOnInit() {
    console.log('onInit calling');
    this.openDialog = false;
    this.getCars();
  }

  getCars() {
    this.carService.getCars().subscribe(cars => this.cars = cars);
  }

  showDialogAddCar(car: CarDto) {
    this.car = car;
    this.openDialog = true;

  }

  closeCarDialog(event) {
    this.openDialog = false;
  }

  addCar(event) {
    this.getCars();
    this.cars.push(event);
  }

  deleteCar(car: CarDto) {
    this.carService.deleteCar(car);
    const index = this.cars.indexOf(car, 0);
    if (index > -1) {
      this.cars.splice(index, 1);
    }
  }
}
