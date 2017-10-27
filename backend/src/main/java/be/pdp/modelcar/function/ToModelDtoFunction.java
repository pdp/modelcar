package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.dto.ModelDto;
import com.google.common.base.Function;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ToModelDtoFunction implements Function <Model, ModelDto> {

    @Inject
    private ToBrandDtoFunction toBrandDtoFunction;

    @Override
    public ModelDto apply(Model model) {
        ModelDto dto = new ModelDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setType(model.getType());
        dto.setProductionDate(model.getProductionDate());
        dto.setBrandDto(toBrandDtoFunction.apply(model.getBrand()));
        return dto;
    }
}
