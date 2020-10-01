package com.codegym.service.impl;

import com.codegym.model.CinemaDiscount;
import com.codegym.repository.CinemaDiscountRepository;
import com.codegym.service.CinemaDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CinemaDiscountServiceImpl implements CinemaDiscountService {

    @Autowired
    private CinemaDiscountRepository cinemaDiscountRepository;

    @Override
    public Page<CinemaDiscount> findAll(Pageable pageable) {
        return cinemaDiscountRepository.findAll(pageable);
    }

    @Override
    public CinemaDiscount findById(int id) {
        return cinemaDiscountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CinemaDiscount cinemaDiscount) {
        cinemaDiscountRepository.save(cinemaDiscount);
    }

    @Override
    public void remove(int id) {
        cinemaDiscountRepository.deleteById(id);
    }

    @Override
    public Page<CinemaDiscount> findAllCinemaDiscountBySearch(String search, String by, Pageable pageable) {
        switch (by){
            case "startTime":
                return cinemaDiscountRepository.findAllByStartDateContaining(search,pageable);
            case "endTime":
                return cinemaDiscountRepository.findAllByEndDateContaining(search,pageable);
            case "discount":
                if (search.matches("^\\d$")) {
                    return cinemaDiscountRepository.findAllByDiscount(Integer.parseInt(search), pageable);
                }else {return null;}
            default:
                return cinemaDiscountRepository.findAllByDiscountOrStartDateContainingOrEndDateContaining(Integer.parseInt(search),search,search,pageable);
        }
    }
}
