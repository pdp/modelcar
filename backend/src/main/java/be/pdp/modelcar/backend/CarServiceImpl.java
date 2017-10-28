package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Brand;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.dto.ColorDto;
import be.pdp.modelcar.dto.ModelDto;
import be.pdp.modelcar.factory.CarFactory;
import be.pdp.modelcar.function.ToBrandDtoFunction;
import be.pdp.modelcar.function.ToCarDtoFunction;
import be.pdp.modelcar.function.ToColorDtoFunction;
import be.pdp.modelcar.function.ToModelDtoFunction;
import com.google.common.collect.FluentIterable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by peterdp on 27/10/2017.
 */
@Service
public class CarServiceImpl implements CarService {

    @Inject
    private ToCarDtoFunction toCarDtoFunction;

    @Inject
    private ToBrandDtoFunction toBrandDtoFunction;

    @Inject
    private ToModelDtoFunction toModelDtoFunction;

    @Inject
    private ToColorDtoFunction toColorDtoFunction;

    @Inject
    private CarRepository carRepository;

    @Inject
    private BrandRepository brandRepository;

    @Inject
    private ColorRepository colorRepository;

    @Inject
    private ModelRepository modelRepository;

    @Inject
    private CarFactory carFactory;

    @Override
    public List<CarDto> findAllBy(Pageable pageable) {
        List<Car> cars = carRepository.findAllBy(pageable);
        return mapCarsToCarDtos(cars);
    }

    public void save(CarDto carDto) {
        Car car = carFactory.createCar(carDto);
        carRepository.save(car);
    }

    private List<CarDto> mapCarsToCarDtos(List<Car> cars) {
        return FluentIterable
                .from(cars)
                .transform(toCarDtoFunction)
                .toList();
    }

    public List<BrandDto> findAllBrands() {
        return FluentIterable
            .from(brandRepository.findAll())
            .transform(toBrandDtoFunction)
            .toList();
    }

    public List<ColorDto> findAllColors() {
        return FluentIterable
                .from(colorRepository.findAll())
                .transform(toColorDtoFunction)
                .toList();
    }

    public List<ModelDto> findByBrandId(Long brandId) {
        return FluentIterable
            .from(modelRepository.findByBrandId(brandId))
            .transform(toModelDtoFunction)
            .toList();
    }
}
