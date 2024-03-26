package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionMapper;
import nl.novi.techiteasy.model.Television;
import nl.novi.techiteasy.services.TelevisionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // Definieer je endpoints hier

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisions = televisionService.getAllTelevisions();
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {
        TelevisionDto television = televisionService.getTelevisionById(id);
        return new ResponseEntity<>(television, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision(@RequestBody TelevisionInputDto televisionInputDto) {
        Television television = televisionService.createTelevision(televisionInputDto);
        TelevisionDto createdTelevisionDto = TelevisionMapper.toTelevisionDto(television);
        return new ResponseEntity<>(createdTelevisionDto, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto) {
        Television updatedTelevision = televisionService.updateTelevision(id, televisionInputDto);
        TelevisionDto updatedTelevisionDto = TelevisionMapper.toTelevisionDto(updatedTelevision);
        return new ResponseEntity<>(updatedTelevisionDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
