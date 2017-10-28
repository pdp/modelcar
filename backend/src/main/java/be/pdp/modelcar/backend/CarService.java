package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.dto.ColorDto;
import be.pdp.modelcar.dto.ModelDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by peterdp on 27/10/2017.
 */
public interface CarService {

    List<BrandDto> findAllBrands();

    List<ColorDto> findAllColors();

    List<ModelDto> findByBrandId(Long brandId);

    List<CarDto> findAllBy(Pageable pageable );

    void save(CarDto carDto);

}
