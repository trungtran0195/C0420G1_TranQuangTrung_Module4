package com.codegym.Repositorys;

import com.codegym.Model.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelServiceRepositorys extends JpaRepository<HotelService, String> {
    List<HotelService> findAll();
    Page<HotelService> findAll(Pageable pageable);
    Page<HotelService> findAllByNameServiceContaining(Pageable pageable,String name);
}
