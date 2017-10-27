package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.factory.CarFactory;
import be.pdp.modelcar.function.ToCarDtoFunction;
import com.google.common.collect.FluentIterable;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by peterdp on 27/10/2017.
 */
public class CarServiceImpl implements CarService {

    @Inject
    private ToCarDtoFunction toCarDtoFunction;

    @Inject
    private CarRepository carRepository;

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
}
