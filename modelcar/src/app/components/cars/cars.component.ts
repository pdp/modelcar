import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Car} from '../../domain/Car';
import {CarService} from '../../service/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[] = [];

  car: Car;

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

  showDialogAddCar(event) {
    this.openDialog = true;
    //TODO do not use a hardcoded car
    this.car = this.cars[0];
  }

  closeCarDialog(event) {
    this.openDialog = false;
  }

}
