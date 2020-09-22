package com.codegym.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NhanVien")
public class Staffs {
    @Id
    @Column(name = "IDNhanVien")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ho_Ten")
    private String nameStaff;

    @Column(name = "Ngay_Sinh")
    private Date dateOfBirth;

    @Column(name = "So_CMTND")
    private String personalNumber;

    @Column(name = "Luong")
    private String salary;

    @Column(name = "SDT")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Dia_Chi")
    private String address;

    @OneToOne
    @JoinColumn(name = "department_id")
    private StaffDepartment staffDepartment;

    @OneToOne
    @JoinColumn(name = "degree_id")
    private StaffDegree staffDegree;

    @OneToOne
    @JoinColumn(name = "position_id")
    private StaffPosition staffPosition;

    public Staffs() {
    }

    public Staffs(int id, String nameStaff, Date dateOfBirth, String personalNumber, String salary, String phoneNumber, String email, String address, StaffDepartment staffDepartment, StaffDegree staffDegree, StaffPosition staffPosition) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.dateOfBirth = dateOfBirth;
        this.personalNumber = personalNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.staffDepartment = staffDepartment;
        this.staffDegree = staffDegree;
        this.staffPosition = staffPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public StaffDepartment getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(StaffDepartment staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public StaffDegree getStaffDegree() {
        return staffDegree;
    }

    public void setStaffDegree(StaffDegree staffDegree) {
        this.staffDegree = staffDegree;
    }

    public StaffPosition getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(StaffPosition staffPosition) {
        this.staffPosition = staffPosition;
    }
}
