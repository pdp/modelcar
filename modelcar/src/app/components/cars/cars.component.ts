import { Component, OnInit } from '@angular/core';
import {Car} from '../../domain/Car';
import {CarService} from '../../service/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[] = [];

  constructor(private carService: CarService) { }

  ngOnInit() {
    console.log("onInit calling");
    this.getCars();
  }

  getCars() {
    console.log("getCars calling");
    this.carService.getCars().subscribe(cars => this.cars = cars);
    console.log("getCars called");
  }

}
