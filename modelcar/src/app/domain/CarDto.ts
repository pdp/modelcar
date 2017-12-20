import {BrandDto} from './BrandDto';
import {ColorDto} from './ColorDto';
import {ModelDto} from './ModelDto';
import {ScaleDto} from './ScaleDto';

export class CarDto {
  itemRef: string;
  modelDto: ModelDto;
  colorDto: ColorDto;
  limitedEdition: number;
  coupe: boolean;
  boxed: boolean;
  scale: ScaleDto;

  constructor() {

  }

}


