
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import {Car} from '../domain/Car';

import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';

@Injectable()
export class CarService {

  page: number = 0;

  constructor(private http: Http) {}

  getCars() {
    return this.http.get('http://localhost:8080/cars/?page=0')
      .map((response:Response) => response.json() as Car[]);
  }
}
