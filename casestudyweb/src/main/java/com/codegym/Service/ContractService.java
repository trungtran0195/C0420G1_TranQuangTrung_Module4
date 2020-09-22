package com.codegym.Service;

import com.codegym.Model.Contract;
import com.codegym.Model.ContractDetail;
import com.codegym.Model.ContractExtraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void save (Contract contract);

    void saveContractDetail (ContractDetail contractDetail);

    Contract findById(Long id);

    void remove(Long id);

    Page<Contract> findAll(Pageable pageable);

    List<ContractDetail> findAllContractDetail();

    List<ContractExtraService> findAllExtraService();
}
