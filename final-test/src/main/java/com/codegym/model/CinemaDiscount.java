package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class CinemaDiscount {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Không được để trống")
    private String discountTitle;

    @Column(name = "NgayBatDau")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" , message = "ngày phải đúng định dạng yyyy/mm/dd")
    private String startDate;

    @Column(name = "NgayKetThuc")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" , message = "ngày phải đúng định dạng yyyy/mm/dd")
    private String endDate;

    @Min(value = 10000, message = "phải lớn hơn 10.000")
    @NotEmpty(message = "Không được để trống")
    @Column(name = "GiamGia")
    private int discount;

    @Column(name = "ChiTiet")
    @NotEmpty(message = "Không được để trống")
    private String detail;

    public CinemaDiscount() {
    }

    public CinemaDiscount(int id, String discountTitle, @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$", message = "ngày phải đúng định dạng yyyy/mm/dd") String startDate, @Pattern(regexp = "^((19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$", message = "ngày phải đúng định dạng yyyy/mm/dd") String endDate, @Min(value = 10000, message = "phải lớn hơn 10.000") int discount, String detail) {
        this.id = id;
        this.discountTitle = discountTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
