package rs.ac.singidunum.ispit_zadatak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.ispit_zadatak.entity.Part;
import rs.ac.singidunum.ispit_zadatak.model.PartModel;
import rs.ac.singidunum.ispit_zadatak.service.PartService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path ="/part" )
public class PartController {
    private final PartService serivce;

    @GetMapping
    public List<Part> getAll(){
        return serivce.getAllPart();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Part> getById(@PathVariable Integer id){
        return ResponseEntity.of(serivce.getPartById(id));
    }
    @PostMapping
    public Part creat(@RequestBody PartModel model){
        return serivce.savePart(model);
    }

    @PutMapping(path = "/{id}")
    public Part update(@PathVariable Integer id,@RequestBody PartModel model){
        return serivce.updatePart(id,model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        serivce.deletePart(id);
    }
}
