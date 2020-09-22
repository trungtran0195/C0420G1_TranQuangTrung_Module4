package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "BoPhan")
public class StaffDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBoPhan")
    private Long id;

    @Column(name = "TenBoPhan")
    private String nameDepartment;

    public StaffDepartment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

}
