package be.pdp.modelcar.factory;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.domain.Scale;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.CarDto;
import org.springframework.stereotype.Component;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class BrandFactory {

    public Brand createBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        return brand;
    }
}
