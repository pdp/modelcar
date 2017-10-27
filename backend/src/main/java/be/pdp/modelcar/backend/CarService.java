package be.pdp.modelcar.backend;

import be.pdp.modelcar.domain.Car;
import be.pdp.modelcar.dto.CarDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by peterdp on 27/10/2017.
 */
public interface CarService {

    List<CarDto> findAllBy(Pageable pageable );

    void save(CarDto carDto);

}
