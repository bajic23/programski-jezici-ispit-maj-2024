package rs.ac.singidunum.ispit_zadatak.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.ispit_zadatak.entity.Car;
import rs.ac.singidunum.ispit_zadatak.entity.Part;
import rs.ac.singidunum.ispit_zadatak.model.CarModel;
import rs.ac.singidunum.ispit_zadatak.repository.CarRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final PartService partService;

    public List<Car> getAllCars(){
        return repository.findAllByDeletedAtIsNull();
    }
    public Optional<Car> getCarById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Car createCar(CarModel model) {
        Car car = new Car();
        Part part= partService.getPartById(model.getPartId()).orElseThrow();
        car.setCar_manufacturer(model.getManufacturer());
        car.setCar_model(model.getModel());
        car.setCar_release_year(model.getRelease_year());
        car.setPart(part);
        return repository.save(car);
    }
    public Car updateCar(Integer id,CarModel model){
        Car car = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        Part part= partService.getPartById(model.getPartId()).orElseThrow();
        car.setCar_manufacturer(model.getManufacturer());
        car.setCar_model(model.getModel());
        car.setCar_release_year(model.getRelease_year());
        car.setPart(part);
        car.setUpdatedAt(LocalDateTime.now());
        return repository.save(car);
    }
    public void deletedCar(Integer id){
        Car car = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        car.setDeletedAt(LocalDateTime.now());
        repository.save(car);
    }
}
