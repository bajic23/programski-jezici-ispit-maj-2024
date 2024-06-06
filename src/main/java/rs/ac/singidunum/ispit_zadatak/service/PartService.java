package rs.ac.singidunum.ispit_zadatak.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.ispit_zadatak.entity.Part;
import rs.ac.singidunum.ispit_zadatak.model.PartModel;
import rs.ac.singidunum.ispit_zadatak.repository.PartRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository repository;
    public List<Part> getAllPart(){
        return repository.findAllByDeletedAtIsNull();
    }
    public Optional<Part> getPartById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id);
    }
    public Part savePart(PartModel model){
        Part part = new Part();
        part.setName(model.getName());
        part.setFuel_type(model.getFuel_type());
        return repository.save(part);
    }
    public Part updatePart(Integer id, PartModel model){
        Part part = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        part.setName(model.getName());
        part.setFuel_type(model.getFuel_type());
        part.setUpdatedAt(LocalDateTime.now());
        return repository.save(part);
    }
    public void  deletePart(Integer id){
        Part part = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        part.setDeletedAt(LocalDateTime.now());
        repository.save(part);
    }
}
