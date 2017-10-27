package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.CarDto;
import com.google.common.base.Function;

/**
 * Created by peterdp on 27/10/2017.
 */
public class ToCarDtoFunction implements Function <Car, CarDto> {

    @Override
    public CarDto apply(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setItemRef(car.getItemRef());
        dto.setBrandName(car.getBrand().getName());
        dto.setBoxed(car.isBoxed());
        dto.setLimitedEdition(car.getLimitedEdition());
        dto.setModelName(car.getModel().getName());
        dto.setModelType(car.getModel().getType());
        dto.setProductionDate(car.getModel().getProductionDate());
        dto.setColor(car.getColor().getName());
        return dto;
    }
}
