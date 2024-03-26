package nl.novi.techiteasy.dtos;

import nl.novi.techiteasy.model.Television;

public class TelevisionMapper {

    // Converteer Television naar TelevisionDto
    public static TelevisionDto toTelevisionDto(Television television) {
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType().toString());
        dto.setScreenQuality(television.getScreenQuality().toString());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());

        return dto;
    }

    // Converteer TelevisionDto naar Television
    public static Television toTelevision(TelevisionInputDto dto) {
        Television television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(Television.ScreenType.valueOf(dto.getScreenType()));
        television.setScreenQuality(Television.ScreenQuality.valueOf(dto.getScreenQuality()));
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());


        return television;
    }
}
