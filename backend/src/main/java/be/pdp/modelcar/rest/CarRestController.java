package be.pdp.modelcar.rest;

import be.pdp.modelcar.backend.CarService;
import be.pdp.modelcar.dto.BrandDto;
import be.pdp.modelcar.dto.CarDto;
import be.pdp.modelcar.dto.ModelDto;
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
    private CarService carService;

    @RequestMapping("/brands")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getBrands() {
        List<BrandDto>  brandDtos = carService.findAllBrands();
        return new ResponseEntity(brandDtos.toArray(), HttpStatus.OK);
    }

    @RequestMapping("/models")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getModels(@RequestParam("brandId") Long brandId) {
        List<ModelDto> modelDtos = carService.findByBrandId(brandId);
        return new ResponseEntity(modelDtos.toArray(), HttpStatus.OK);
    }

    @RequestMapping("/cars")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getCars(@RequestParam("page") int page) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "brand.id"));

        Pageable pageable = new PageRequest(page, 5, sort);

        List<CarDto> carDtos = carService.findAllBy(pageable);

        return new ResponseEntity(carDtos.toArray(), HttpStatus.OK);
    }

    @PostMapping(value="/createcar")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> createCar(@RequestBody CarDto carDto, UriComponentsBuilder ucBuilder) {
        carService.save(carDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/car/{itemRef}").buildAndExpand(carDto.getItemRef()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

