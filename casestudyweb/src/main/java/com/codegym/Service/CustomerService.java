package com.codegym.Service;

import com.codegym.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save (Customer customer);

    Customer findById(String id);

    List<Customer>findAll();

    Page<Customer>findAll(Pageable pageable);

    Page<Customer>findAllByName(Pageable pageable,String name);

    void remove(String id);

    Boolean noMatchID(String customer);

}
