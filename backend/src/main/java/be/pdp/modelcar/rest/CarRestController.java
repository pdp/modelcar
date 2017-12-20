package be.pdp.modelcar.rest;

import be.pdp.modelcar.backend.CarService;
import be.pdp.modelcar.dto.*;
import org.springframework.data.domain.PageImpl;
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

    @RequestMapping("/colors")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getColors() {
        List<ColorDto> colorDtos = carService.findAllColors();
        return new ResponseEntity(colorDtos.toArray(), HttpStatus.OK);
    }

    @RequestMapping("/scales")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getScales() {
        List<ScaleDto> scaleDtos = carService.findAllScales();
        return new ResponseEntity(scaleDtos.toArray(), HttpStatus.OK);
    }

    @RequestMapping("/cars")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getCars(@RequestParam("page") int page) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));

        Pageable pageable = new PageRequest(page, 50, sort);

        List<CarDto> carDtos = carService.findAllBy(pageable);

        return new ResponseEntity(carDtos.toArray(), HttpStatus.OK);
    }

    @PostMapping(value="/car/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> createCar(@RequestBody CarDto carDto, UriComponentsBuilder ucBuilder) {
        carService.save(carDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/car/{itemRef}").buildAndExpand(carDto.getItemRef()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/car/delete/{carId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable String carId) {
        carService.delete(carId);
    }
}

