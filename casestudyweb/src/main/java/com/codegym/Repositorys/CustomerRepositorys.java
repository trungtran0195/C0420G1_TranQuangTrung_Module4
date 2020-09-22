package com.codegym.Repositorys;

import com.codegym.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositorys extends JpaRepository<Customer, String> {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findAllById(String customerId);
    Page<Customer> findAllByNameContaining(Pageable pageable,String name);
}
