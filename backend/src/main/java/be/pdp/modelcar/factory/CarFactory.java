package be.pdp.modelcar.factory;

import be.pdp.modelcar.backend.ModelRepository;
import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.domain.Model;
import be.pdp.modelcar.domain.Scale;
import be.pdp.modelcar.dto.CarDto;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by peterdp on 27/10/2017.
 */
@Component
public class CarFactory {

    public Car createCar(CarDto carDto) {
        Car car = new Car();
        car.setCoupe(carDto.isCoupe());
        car.setBoxed(carDto.isBoxed());
        car.setLimitedEdition(carDto.getLimitedEdition());
        car.setScale(Scale.getScale(carDto.getScale().name()));
        return car;
    }
}
