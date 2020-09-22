package com.codegym.Service.impl;


import com.codegym.Model.Customer;
import com.codegym.Repositorys.CustomerRepositorys;
import com.codegym.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("CustomerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepositorys customerRepositorys;

    @Override
    public void save(Customer customer) {
        customerRepositorys.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepositorys.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepositorys.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepositorys.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable,String name) {
        return customerRepositorys.findAllByNameContaining(pageable,name);
    }

    @Override
    public void remove(String id) {
        customerRepositorys.deleteById(id);
    }

    @Override
    public Boolean noMatchID(String customer) {
        return customerRepositorys.findById(customer) == null;
    }
}
