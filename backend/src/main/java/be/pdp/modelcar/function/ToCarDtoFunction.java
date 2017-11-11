package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.CarDto;
import com.google.common.base.Function;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ToCarDtoFunction implements Function <Car, CarDto> {

    @Inject
    private ToModelDtoFunction toModelDtoFunction;

    @Inject
    private ToColorDtoFunction toColorDtoFunction;

    @Override
    public CarDto apply(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setItemRef(car.getItemRef());
        dto.setBoxed(car.isBoxed());
        dto.setLimitedEdition(car.getLimitedEdition());
        dto.setModelDto(toModelDtoFunction.apply(car.getModel()));
        dto.setColorDto(toColorDtoFunction.apply(car.getColor()));
        return dto;
    }
}
