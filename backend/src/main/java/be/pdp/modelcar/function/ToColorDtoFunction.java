package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.domain.Color;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.dto.ColorDto;
import com.google.common.base.Function;
import org.springframework.stereotype.Component;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ToColorDtoFunction implements Function <Color, ColorDto> {

    @Override
    public ColorDto apply(Color color) {
        ColorDto dto = new ColorDto();
        dto.setId(color.getId());
        dto.setName(color.getName());
        return dto;
    }
}
