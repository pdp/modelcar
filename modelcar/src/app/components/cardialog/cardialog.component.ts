import {Component, EventEmitter, Input, OnInit, Output, ViewEncapsulation} from '@angular/core';
import {CarDto} from '../../domain/CarDto';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BrandDto} from '../../domain/BrandDto';
import {CarService} from '../../service/car.service';
import {ModelDto} from '../../domain/ModelDto';
import {ColorDto} from '../../domain/ColorDto';
import {ToCarDtoMapper} from '../../mapper/ToCarDtoMapper';
import {Scale} from '../../domain/Scale';

@Component({
  selector: 'app-cardialog',
  templateUrl: './cardialog.component.html',
  styleUrls: ['./cardialog.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CardialogComponent implements OnInit {

  @Input() display: boolean;

  @Input() car: CarDto;

  @Output() close: EventEmitter<CarDto> = new EventEmitter<CarDto>();

  carDialogForm: FormGroup;

  brand: BrandDto;

  brands: BrandDto[] = [];

  filteredBrands: BrandDto[];

  model: ModelDto;

  models: ModelDto[] = [];

  filteredModels: ModelDto[];

  color: ColorDto;

  colors: ColorDto[] = [];

  filteredColors: ColorDto[];

  scale: Scale;

  scales: Scale[] = [];

  filteredScales: Scale[];

  itemReference: string;

  limitedEdition: number;

  coupe: boolean;

  boxed: boolean;

  constructor(private fb: FormBuilder, private carService: CarService, private toCarDtoMapper: ToCarDtoMapper) {
    this.buildForm();
  }

  ngOnInit() {
    this.display = false;
    this.carService.getBrands().subscribe(brands => this.brands = brands);
    this.carService.getColors().subscribe(colors => this.colors = colors);
    this.carService.getScales().subscribe(scales => this.scales = scales);
  }

  buildForm() {
    this.carDialogForm = this.fb.group({
      brand: [''],
      model: [''],
      itemRef: [''],
      limitedEdition: [''],
      scale: [''],
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

  selectBrand(event: BrandDto) {
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

  filterColors(event) {
    this.filteredColors = [];
    for (let i = 0; i < this.colors.length; i++) {
      const color = this.colors[i];
      if (color.name.toLowerCase().includes(event.query.toLowerCase(), 0)) {
        this.filteredColors.push(color);
      }
    }
  }

  filterScales(event) {
    this.filteredScales = [];
    for (let i = 0; i < this.scales.length; i++) {
      const scale = this.scales[i];
      if (scale.name.toLowerCase().includes(event.query.toLowerCase(), 0)) {
        this.filteredScales.push(scale);
      }
    }
  }

  saveCar() {
    const newCar = this.toCarDtoMapper.map(this.carDialogForm.value);
    this.carService.saveCar(newCar);
  }

  closeDialog() {
    this.close.emit(this.car);
  }

  click() {
    this.closeDialog();
  }
}
