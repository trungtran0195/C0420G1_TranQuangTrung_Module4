package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "TrinhDo")
public class StaffDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTrinhDo")
    private Long id;

    @Column(name = "TrinhDo")
    private String degree;

    public StaffDegree() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
