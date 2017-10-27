import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Car} from '../../domain/Car';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Brand} from '../../domain/Brand';

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

  brand: string;

  brands: string[] = ['Audi','BMW','Fiat','Ford','Honda','Jaguar','Mercedes','Renault','Volvo','VW'];

  filteredBrands: any[];

  constructor(private fb: FormBuilder) {
    this.buildForm();
  }

  ngOnInit() {
    this.display = false;
  }

  buildForm() {
    this.carDialogForm = this.fb.group({
      brand: ['', Validators.required]
    });
  }

  filterBrands(event) {
    this.filteredBrands = [];
    for(let i = 0; i < this.brands.length; i++) {
      let brand = this.brands[i];
      if(brand.toLowerCase().indexOf(event.query.toLowerCase()) == 0) {
        this.filteredBrands.push(brand);
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
