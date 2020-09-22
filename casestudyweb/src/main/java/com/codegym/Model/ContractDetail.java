package com.codegym.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "HopDongChiTiet")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHopDongChiTiet")
    private Long id;

    @Column(name = "SoLuong")
    @Min(value = 1, message = "phai la so nguyen duong")
    private String numberOfContract;

    @OneToOne
    @JoinColumn(name = "id_extra_service")
    private ContractExtraService contractExtraService;

    public ContractDetail() {
    }

    public ContractDetail(Long id, String numberOfContract, ContractExtraService contractExtraService) {
        this.id = id;
        this.numberOfContract = numberOfContract;
        this.contractExtraService = contractExtraService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOfContract() {
        return numberOfContract;
    }

    public void setNumberOfContract(String numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public ContractExtraService getContractExtraService() {
        return contractExtraService;
    }

    public void setContractExtraService(ContractExtraService contractExtraService) {
        this.contractExtraService = contractExtraService;
    }
}
