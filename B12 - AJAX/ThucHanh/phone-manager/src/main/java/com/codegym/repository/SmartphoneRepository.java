package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
    List<Smartphone> findAll();
}