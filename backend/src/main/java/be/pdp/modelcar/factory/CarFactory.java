package be.pdp.modelcar.factory;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.CarDto;

/**
 * Created by peterdp on 27/10/2017.
 */
public class CarFactory {

    public Car createCar(CarDto carDto) {
        Car car = new Car();
        return car;
    }
}
