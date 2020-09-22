package com.codegym.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "HopDong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHopDong")
    private Long id;

    @Column(name = "NgayLamHopDong")
    @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" , message = "ngày phải đúng định dạng yyyy/mm/dd")
    private String startDate;

    @Column(name = "NgayKetThuc")
    @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" , message = "ngày phải đúng định dạng yyyy/mm/dd")
    private String endDate;

    @Min(value = 1, message = "phai la so nguyen duong")
    @Column(name = "TienDatCoc")
    private String deposits;

    @Min(value = 1, message = "phai la so nguyen duong")
    @Column(name = "TongTien")
    private String totalPay;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "id_staff")
    private Staffs staff;

    @OneToOne
    @JoinColumn(name = "id_hotel_service")
    private HotelService hotelService;

    @OneToOne
    @JoinColumn(name = "id_contract_detail")
    private ContractDetail contractDetail;

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposits() {
        return deposits;
    }

    public void setDeposits(String deposits) {
        this.deposits = deposits;
    }

    public String getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(String totalPay) {
        this.totalPay = totalPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staffs getStaff() {
        return staff;
    }

    public void setStaff(Staffs staff) {
        this.staff = staff;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }
}
