package be.pdp.modelcar.rest;

import be.pdp.modelcar.backend.CarRepository;
import be.pdp.modelcar.domain.Car;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by peterdp on 20/10/2017.
 */
@RestController
public class CarRestController {

        @Inject
        private CarRepository carRepository;

        @RequestMapping("/cars")
        @CrossOrigin(origins = "http://localhost:4200")
        public ResponseEntity getCars(@RequestParam("page") int page) {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "brand.id"));

            Pageable pageable = new PageRequest(page, 5, sort);

            List<Car> cars = carRepository.findAllBy(pageable);

            return new ResponseEntity(cars.toArray(), HttpStatus.OK);
        }

        @PostMapping(value="/createcar")
        @CrossOrigin(origins = "http://localhost:4200")
        public ResponseEntity<Void> createCar(@RequestBody Car car, UriComponentsBuilder ucBuilder) {
            carRepository.save(car);

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/car/{itemRef}").buildAndExpand(car.getItemRef()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
    }

