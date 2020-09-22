package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "KieuThue")
public class HotelServiceRentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDKieuThue")
    private Long id;

    @Column(name = "TenKieuThue")
    private String nameRentType;

    @Column(name = "Gia")
    private String rentTypePrice;

    public HotelServiceRentType() {
    }

    public HotelServiceRentType(Long id, String nameRentType, String rentTypePrice) {
        this.id = id;
        this.nameRentType = nameRentType;
        this.rentTypePrice = rentTypePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public String getRentTypePrice() {
        return rentTypePrice;
    }

    public void setRentTypePrice(String rentTypePrice) {
        this.rentTypePrice = rentTypePrice;
    }

}

