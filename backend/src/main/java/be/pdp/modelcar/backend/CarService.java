package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.dto.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by peterdp on 27/10/2017.
 */
public interface CarService {

    List<BrandDto> findAllBrands();

    List<ColorDto> findAllColors();

    List<ScaleDto> findAllScales();

    List<ModelDto> findByBrandId(Long brandId);

    List<CarDto> findAllBy(Pageable pageable );

    Car save(CarDto carDto);

    void delete(String carId);

    Brand saveBrand(BrandDto brandDto);

    Model saveModel(ModelDto modelDto);

}
