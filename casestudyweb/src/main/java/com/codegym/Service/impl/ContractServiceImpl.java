package com.codegym.Service.impl;

import com.codegym.Model.Contract;
import com.codegym.Model.ContractDetail;
import com.codegym.Model.ContractExtraService;
import com.codegym.Repositorys.ContractDetailRepository;
import com.codegym.Repositorys.ContractRepository;
import com.codegym.Repositorys.ExtraServiceRepository;
import com.codegym.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private ExtraServiceRepository extraServiceRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractExtraService> findAllExtraService() {
        return extraServiceRepository.findAll();
    }
}
