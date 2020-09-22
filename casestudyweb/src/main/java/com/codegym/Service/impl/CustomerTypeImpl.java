package com.codegym.Service.impl;

import com.codegym.Model.CustomerType;
import com.codegym.Repositorys.CustomerTypeRepositorys;
import com.codegym.Service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeImpl implements CustomerTypeService {

    @Autowired
    CustomerTypeRepositorys customerTypeRepositorys;

    @Override
    public List<CustomerType> findAll(){
        return customerTypeRepositorys.findAll();
    }
}
