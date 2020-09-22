package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "LoaiKhach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLoaiKhach")
    private Long id;

    @Column(name = "TenLoaiKhach")
    private String nameCustomerType;

    public CustomerType() {
    }

    public CustomerType(Long id, String nameCustomerType) {
        this.id = id;
        this.nameCustomerType = nameCustomerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

}
