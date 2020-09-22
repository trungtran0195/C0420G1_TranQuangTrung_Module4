package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "LoaiDichVu")
public class HotelServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDLoaiDichVu")
    private Long id;

    @Column(name = "TenLoaiDichVu")
    private String nameServiceType;

    public HotelServiceType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }
}
