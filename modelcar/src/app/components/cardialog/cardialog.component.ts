import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Car} from '../../domain/Car';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Brand} from '../../domain/Brand';
import {CarService} from '../../service/car.service';
import {Model} from '../../domain/Model';

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

  constructor(private fb: FormBuilder, private carService: CarService) {
    this.buildForm();
  }

  ngOnInit() {
    this.display = false;
    this.carService.getBrands().subscribe(brands => this.brands = brands);
  }

  buildForm() {
    this.carDialogForm = this.fb.group({
      brand: ['', Validators.required],
      model: ['', Validators.required]
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

  }

  closeDialog() {
    this.close.emit(this.car);
  }

  click() {
    this.closeDialog();
  }
}
