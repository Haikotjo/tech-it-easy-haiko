package nl.novi.techiteasy.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.techiteasy.dtos.TelevisionDto;
import nl.novi.techiteasy.dtos.TelevisionInputDto;
import nl.novi.techiteasy.dtos.TelevisionMapper;
import nl.novi.techiteasy.model.Television;
import nl.novi.techiteasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = repos.findAll();
        return televisions.stream()
                .map(TelevisionMapper::toTelevisionDto)
                .collect(Collectors.toList());
    }

    public TelevisionDto getTelevisionById(Long id) {
        Television television = repos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Television " + id + " not found"));

        return TelevisionMapper.toTelevisionDto(television);
    }

    public Television saveTelevision(Television television) {
        return repos.save(television);
    }

    public Television updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        Television television = repos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Television " + id + " not found"));

        // Update de velden van de bestaande televisie met die van de televisie-input DTO
        television.setType(televisionInputDto.getType());
        television.setBrand(televisionInputDto.getBrand());
        television.setName(televisionInputDto.getName());
        television.setPrice(televisionInputDto.getPrice());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setWifi(televisionInputDto.getWifi());
        // Voeg hier andere velden toe die bijgewerkt moeten worden

        return repos.save(television);
    }

    public void deleteTelevision(Long id) {
        Television television = repos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Television " + id + " not found"));
        repos.delete(television);
    }

    public Television createTelevision(TelevisionInputDto inputDto) {
        Television television = TelevisionMapper.toTelevision(inputDto);
        return repos.save(television);
    }


}
