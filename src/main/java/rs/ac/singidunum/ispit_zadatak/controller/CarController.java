package rs.ac.singidunum.ispit_zadatak.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.ispit_zadatak.entity.Car;
import rs.ac.singidunum.ispit_zadatak.model.CarModel;
import rs.ac.singidunum.ispit_zadatak.service.CarService;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
@RequiredArgsConstructor
@CrossOrigin
public class CarController {

    private final CarService service;

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getCarById(id));
    }
    @PostMapping
    public Car createCar(@RequestBody CarModel car){
        return service.createCar(car);
    }
    @PutMapping(path = "/{id}")
    public Car updateCar(@PathVariable Integer id,@RequestBody CarModel car){
        return service.updateCar(id,car);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletedCar(@PathVariable Integer id){
        service.deletedCar(id);
    }
}
