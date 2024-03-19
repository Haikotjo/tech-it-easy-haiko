package nl.novi.techiteasy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "televisions")
public class Television {
    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String brand;
    private String name;
    private Double price;

    @Column(name = "available_size")
    private Double availableSize;

    @Column(name = "refresh_rate")
    private Double refreshRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "screen_type")
    private ScreenType screenType;
    @Enumerated(EnumType.STRING)
    @Column(name = "screen_quality")
    private ScreenQuality screenQuality;

    @Column(name = "smart_tv")
    private Boolean smartTv;

    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;

    @Column(name = "original_stock")
    private Integer originalStock;

    private Integer sold;

    private LocalDate originalStockDate;

    private LocalDate soldDate;

    public enum ScreenType {
        LED, LCD, OLED, QLED
    }

    public enum ScreenQuality {
        HD, FULL_HD, UHD, QHD
    }


//    constructors

    public Television() {

    }

    public Television(String type, String brand, String name, Double price, Double availableSize, Double refreshRate, ScreenType screenType, ScreenQuality screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock, Integer sold, LocalDate originalStockDate, LocalDate soldDate) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.originalStockDate = originalStockDate;
        this.soldDate = soldDate;
    }


//    getters and setters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public ScreenQuality getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(ScreenQuality screenQuality) {
        this.screenQuality = screenQuality;
    }


    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public LocalDate getOriginalStockDate() {
        return originalStockDate;
    }

    public void setOriginalStockDate(LocalDate originalStockDate) {
        this.originalStockDate = originalStockDate;
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }
}
