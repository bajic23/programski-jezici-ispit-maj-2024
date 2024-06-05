package rs.ac.singidunum.ispit_zadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.ispit_zadatak.entity.Part;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
    List<Part> findAllByDeletedAtIsNull();
    Optional<Part> findByIdAndDeletedAtIsNull(Integer id);
}
