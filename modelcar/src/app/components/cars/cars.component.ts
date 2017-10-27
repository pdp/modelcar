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

  openDialog: boolean;

  constructor(private carService: CarService) { }

  ngOnInit() {
    console.log("onInit calling");
    this.openDialog = false;
    this.getCars();
  }

  getCars() {
    console.log("getCars calling");
    this.carService.getCars().subscribe(cars => this.cars = cars);
    console.log("getCars called");
  }

  showDialogAddCar(event) {
    console.log('add car button clicked');
    this.openDialog = true;
  }

}
