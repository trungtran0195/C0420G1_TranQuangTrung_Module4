package com.codegym.Repositorys;

import com.codegym.Model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepositorys extends JpaRepository<CustomerType, Long> {
}
