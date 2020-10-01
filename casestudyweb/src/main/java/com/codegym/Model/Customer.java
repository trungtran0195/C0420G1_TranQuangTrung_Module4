package com.codegym.Model;

import com.codegym.validator.UniqueID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "KhachHang")
public class Customer{
    @Id
    @UniqueID(message = "Id already exist")
    @Pattern(regexp = "^KH-\\d{4}$" ,message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)")
    @NotBlank(message = "không được để trống")
    private String id;

    @Column(name = "HoTen")
    @NotBlank(message = "không được để trống")
    private String name;

    @Column(name = "NgaySinh")
    @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" , message = "ngày phải đúng định dạng yyyy/mm/dd")
    private String dayofBirth;

    @Column(name = "SoCMTND")
    @Pattern(regexp = "^\\d{9}$" , message = "Số CMND phải đúng định dạng XXXXXXXXX (X là số 0-9)")
    private String personalnumber;

    @Column(name = "SDT")
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^(090|091)\\d{7}$" ,message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx")
    private String phonenumber;

    @Column(name = "Email")
    @NotBlank(message = "không được để trống")
    @Email
    private String email;

    @Column(name = "DiaChi")
    @NotBlank(message = "không được để trống")
    private String address;

    @OneToOne
    @JoinColumn(name = "id_customer_type")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(String id, String name, String dayofBirth, String personalnumber, String phonenumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dayofBirth = dayofBirth;
        this.personalnumber = personalnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayofBirth() {
        return dayofBirth;
    }

    public void setDayofBirth(String dayofBirth) {
        this.dayofBirth = dayofBirth;
    }

    public String getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(String personalnumber) {
        this.personalnumber = personalnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}