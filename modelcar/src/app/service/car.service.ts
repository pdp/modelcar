
import {Injectable} from '@angular/core';
import {Headers, RequestOptions, Response, URLSearchParams} from '@angular/http';
import {CarDto} from '../domain/CarDto';

import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import {BrandDto} from '../domain/BrandDto';
import {ModelDto} from '../domain/ModelDto';
import {ColorDto} from '../domain/ColorDto';
import {ScaleDto} from '../domain/ScaleDto';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Params} from '@angular/router';

@Injectable()
export class CarService {

  page = 0;

  constructor(private http: HttpClient) {}

  getCars() {
    return this.http
      .get<CarDto[]>('http://localhost:8080/cars/?page=0');
  }

  getBrands() {
    return this.http.get<BrandDto[]>('http://localhost:8080/brands');
  }

  getModels(brandId: number) {
    const params = new HttpParams().set('brandId', String(brandId));
    return this.http.get<ModelDto[]>('http://localhost:8080/models', {params: params});
  }

  getColors() {
    return this.http.get<ColorDto[]>('http://localhost:8080/colors');
  }

  getScales() {
    return this.http.get<ScaleDto[]>('http://localhost:8080/scales');
  }

  saveCar(car: CarDto) {
    return this.http.post<CarDto>('http://localhost:8080/car/create', JSON.stringify(car), {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    }).subscribe(newCar => {});
  }

  deleteCar(car: CarDto) {
    // TODO: use businesskey because multiple items with the same itemref can be bought
    return this.http.delete('http://localhost:8080/car/delete/' + car.itemRef).subscribe(res => console.log('car deleted'));
  }
}
