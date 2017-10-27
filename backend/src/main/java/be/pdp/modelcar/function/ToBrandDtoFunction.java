package be.pdp.modelcar.function;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.CarDto;
import com.google.common.base.Function;
import org.springframework.stereotype.Component;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class ToBrandDtoFunction implements Function <Brand, BrandDto> {

    @Override
    public BrandDto apply(Brand brand) {
        BrandDto dto = new BrandDto();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        return dto;
    }
}
