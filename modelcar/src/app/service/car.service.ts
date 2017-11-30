
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response, URLSearchParams} from '@angular/http';
import {CarDto} from '../domain/CarDto';

import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import {BrandDto} from '../domain/BrandDto';
import {ModelDto} from '../domain/ModelDto';
import {ColorDto} from '../domain/ColorDto';
import {Scale} from '../domain/Scale';

@Injectable()
export class CarService {

  page = 0;

  constructor(private http: Http) {}

  getCars() {
    return this.http.get('http://localhost:8080/cars/?page=0')
      .map((response: Response) => response.json() as CarDto[]);
  }

  getBrands() {
    return this.http.get('http://localhost:8080/brands')
      .map((response: Response) => response.json() as BrandDto[]);
  }

  getModels(brandId: number) {
    const myparams = new URLSearchParams();
    myparams.append('brandId', String(brandId));
    const options = new RequestOptions({params: myparams});

    return this.http.get('http://localhost:8080/models', options)
      .map((response: Response) => response.json() as ModelDto[])
      ;
  }

  getColors() {
    return this.http.get('http://localhost:8080/colors')
      .map((response: Response) => response.json() as ColorDto[]);
  }

  getScales() {
    return this.http.get('http://localhost:8080/scales')
      .map((response: Response) => response.json() as Scale[]);
  }

  saveCar(car: CarDto) {
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post('http://localhost:8080/car/create', JSON.stringify(car), {headers})
      .subscribe(newCar => {});
  }
}
