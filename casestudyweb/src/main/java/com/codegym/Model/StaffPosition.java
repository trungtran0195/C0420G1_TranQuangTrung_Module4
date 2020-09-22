package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "ViTri")
public class StaffPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDViTri")
    private Long id;

    @Column(name = "TenViTri")
    private String namePosition;

    public StaffPosition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
