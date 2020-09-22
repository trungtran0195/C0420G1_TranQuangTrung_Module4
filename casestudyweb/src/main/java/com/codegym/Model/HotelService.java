package com.codegym.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "DichVu")
public class HotelService {
    @Id
    @Column(name = "IDDichVu")
    @Pattern(regexp = "^DV-\\d{4}$" ,message = "Mã dịch vụ có định dạng là DV-XXXX (X là số từ 0-9)")
    private String id;

    @Column(name = "TenDichVu")
    private String nameService;

    @Column(name = "DienTich")
    private String serviceArea;

    @Min(value = 1, message = "phai la so nguyen duong")
    @Column(name = "SoTang")
    private String serviceFloors;

    @Column(name = "SoNguoiToiDa")
    private String limitPax;

    @Column(name = "ChiPhiThue")
    private String serviceRentPrice;

    @Column(name = "TrangThai")
    private String serviceStatus;

    @OneToOne
    @JoinColumn
    private HotelServiceType hotelServiceType;

    @OneToOne
    @JoinColumn
    private HotelServiceRentType hotelServiceRentType;

    public HotelService() {
    }

    public HotelService(String id, String nameService, String serviceArea, String serviceFloors, String limitPax, String serviceRentPrice, String serviceStatus, HotelServiceType hotelServiceType, HotelServiceRentType hotelServiceRentType) {
        this.id = id;
        this.nameService = nameService;
        this.serviceArea = serviceArea;
        this.serviceFloors = serviceFloors;
        this.limitPax = limitPax;
        this.serviceRentPrice = serviceRentPrice;
        this.serviceStatus = serviceStatus;
        this.hotelServiceType = hotelServiceType;
        this.hotelServiceRentType = hotelServiceRentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceFloors() {
        return serviceFloors;
    }

    public void setServiceFloors(String serviceFloors) {
        this.serviceFloors = serviceFloors;
    }

    public String getLimitPax() {
        return limitPax;
    }

    public void setLimitPax(String limitPax) {
        this.limitPax = limitPax;
    }

    public String getServiceRentPrice() {
        return serviceRentPrice;
    }

    public void setServiceRentPrice(String serviceRentPrice) {
        this.serviceRentPrice = serviceRentPrice;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public HotelServiceType getHotelServiceType() {
        return hotelServiceType;
    }

    public void setHotelServiceType(HotelServiceType hotelServiceType) {
        this.hotelServiceType = hotelServiceType;
    }

    public HotelServiceRentType getHotelServiceRentType() {
        return hotelServiceRentType;
    }

    public void setHotelServiceRentType(HotelServiceRentType hotelServiceRentType) {
        this.hotelServiceRentType = hotelServiceRentType;
    }
}
