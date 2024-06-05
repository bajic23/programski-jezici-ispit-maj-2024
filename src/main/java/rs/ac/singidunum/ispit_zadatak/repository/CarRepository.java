package rs.ac.singidunum.ispit_zadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.ispit_zadatak.entity.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findAllByDeletedAtIsNull();
    Optional<Car> findByIdAndDeletedAtIsNull(Integer Id);

}

