package com.codegym.service;

import com.codegym.model.CinemaDiscount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CinemaDiscountService {
    Page<CinemaDiscount> findAll(Pageable pageable);
    CinemaDiscount findById(int id);
    void save (CinemaDiscount cinemaDiscount);
    void remove(int id);
    Page<CinemaDiscount> findAllCinemaDiscountBySearch(String search, String by, Pageable pageable);
}
