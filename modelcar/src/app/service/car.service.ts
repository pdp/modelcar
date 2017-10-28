
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response, URLSearchParams} from '@angular/http';
import {Car} from '../domain/Car';

import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import {Brand} from '../domain/Brand';
import {Model} from '../domain/Model';
import {Color} from '../domain/Color';

@Injectable()
export class CarService {

  page = 0;

  constructor(private http: Http) {}

  getCars() {
    return this.http.get('http://localhost:8080/cars/?page=0')
      .map((response: Response) => response.json() as Car[]);
  }

  getBrands() {
    return this.http.get('http://localhost:8080/brands')
      .map((response: Response) => response.json() as Brand[]);
  }

  getModels(brandId: number) {
    const myparams = new URLSearchParams();
    myparams.append('brandId', String(brandId));
    const options = new RequestOptions({params: myparams});

    return this.http.get('http://localhost:8080/models', options)
      .map((response: Response) => response.json() as Model[])
      ;
  }

  getColors() {
    return this.http.get('http://localhost:8080/colors')
      .map((response: Response) => response.json() as Color[]);
  }

  saveCar(car: Car) {
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post('http://localhost:8080/car/create', JSON.stringify(car), {headers})
      .subscribe(newCar => {});
  }
}
