import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Car} from '../../domain/Car';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Brand} from '../../domain/Brand';
import {CarService} from '../../service/car.service';
import {Model} from '../../domain/Model';
import {Color} from '../../domain/Color';

@Component({
  selector: 'app-cardialog',
  templateUrl: './cardialog.component.html',
  styleUrls: ['./cardialog.component.css']
})
export class CardialogComponent implements OnInit {

  @Input() display: boolean;

  @Input() car: Car;

  @Output() close: EventEmitter<Car> = new EventEmitter<Car>();

  carDialogForm: FormGroup;

  brand: Brand;

  brands: Brand[] = [];

  filteredBrands: Brand[];

  model: Model;

  models: Model[] = [];

  filteredModels: Model[];

  itemReference: string;

  limitedEdition: number;

  colors: Color[] = [];

  color: Color;

  coupe: boolean;

  boxed: boolean;

  constructor(private fb: FormBuilder, private carService: CarService) {
    this.buildForm();
  }

  ngOnInit() {
    this.display = false;
    this.carService.getBrands().subscribe(brands => this.brands = brands);
    this.carService.getColors().subscribe(colors => this.colors = colors);
  }

  buildForm() {
    this.carDialogForm = this.fb.group({
      brand: [''],
      model: ['',],
      itemReference: [''],
      limitedEdition: [''],
      color: [''],
      coupe: [''],
      boxed: ['']

    });
  }

  filterBrands(event) {
    this.filteredBrands = [];
    for (let i = 0; i < this.brands.length; i++) {
      const brand = this.brands[i];
      if (brand.name.toLowerCase().includes(event.query.toLowerCase(), 0)) {
        this.filteredBrands.push(brand);
      }
    }
  }

  selectBrand(event: Brand) {
    this.model = null;
    this.carService.getModels(event.id).subscribe(models => this.models = models);
  }

  filterModels(event) {
    this.filteredModels = [];
    for (let i = 0; i < this.models.length; i++) {
      const model = this.models[i];
      if (model.name.toLowerCase().includes(event.query.toLowerCase(), 0)) {
        this.filteredModels.push(model);
      }
    }
  }

  saveCar() {
    //tODO do not use this car but the car from the form
    this.carService.saveCar(this.car);
  }

  closeDialog() {
    this.close.emit(this.car);
  }

  click() {
    this.closeDialog();
  }
}
