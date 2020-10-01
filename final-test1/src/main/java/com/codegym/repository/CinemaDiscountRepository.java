package com.codegym.repository;

import com.codegym.model.CinemaDiscount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaDiscountRepository extends JpaRepository<CinemaDiscount,Integer> {
    Page<CinemaDiscount> findAll(Pageable pageable);
    Page<CinemaDiscount> findAllByStartDateContaining(String startDate,Pageable pageable);
    Page<CinemaDiscount> findAllByEndDateContaining(String endDate,Pageable pageable);
    Page<CinemaDiscount> findAllByDiscount(int discount,Pageable pageable);
    Page<CinemaDiscount> findAllByStartDateContainingOrEndDateContaining (String startDate,String endDate,Pageable pageable);
}
