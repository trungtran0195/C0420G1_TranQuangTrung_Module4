package com.codegym.Service;

import com.codegym.Model.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelServiceService {
    void save (HotelService hotelService);

    HotelService findById(String id);

    List<HotelService> findAll();

    Page<HotelService> findAll(Pageable pageable);

    Page<HotelService> findAllByName(Pageable pageable,String nameService);

    void remove(String id);
}
