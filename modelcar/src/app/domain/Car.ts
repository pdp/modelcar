import {Brand} from './Brand';
import {Color} from './Color';
import {Model} from './Model';

export class Car {
  itemRef: string;
  brand: Brand;
  model: Model;
  color: Color;
  limitedEdition: number;
  coupe: boolean;
  boxed: boolean;
  scale: string;

  constructor() {

  }

}


