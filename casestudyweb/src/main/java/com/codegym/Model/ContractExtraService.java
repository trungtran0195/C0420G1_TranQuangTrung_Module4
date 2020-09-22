package com.codegym.Model;

import javax.persistence.*;

@Entity
@Table(name = "DichVuDiKem")
public class ContractExtraService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDichVuDiKem")
    private Long id;

    @Column(name = "TenDichVuDiKem")
    private String nameExtraService;

    @Column(name = "Gia")
    private String priceExtraService;

    @Column(name = "DonVi")
    private String unitExtraService;

    @Column(name = "TrangThaiKhaDung")
    private String extraServiceStatus;

    public ContractExtraService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameExtraService() {
        return nameExtraService;
    }

    public void setNameExtraService(String nameExtraService) {
        this.nameExtraService = nameExtraService;
    }

    public String getPriceExtraService() {
        return priceExtraService;
    }

    public void setPriceExtraService(String priceExtraService) {
        this.priceExtraService = priceExtraService;
    }

    public String getUnitExtraService() {
        return unitExtraService;
    }

    public void setUnitExtraService(String unitExtraService) {
        this.unitExtraService = unitExtraService;
    }

    public String getExtraServiceStatus() {
        return extraServiceStatus;
    }

    public void setExtraServiceStatus(String extraServiceStatus) {
        this.extraServiceStatus = extraServiceStatus;
    }
}
