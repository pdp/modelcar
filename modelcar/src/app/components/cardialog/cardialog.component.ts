import {Component, Input, OnInit} from '@angular/core';
import {Car} from '../../domain/Car';

@Component({
  selector: 'app-cardialog',
  templateUrl: './cardialog.component.html',
  styleUrls: ['./cardialog.component.css']
})
export class CardialogComponent implements OnInit {

  @Input() display: boolean;

  @Input() car: Car;

  constructor() { }

  ngOnInit() {
  }
}
