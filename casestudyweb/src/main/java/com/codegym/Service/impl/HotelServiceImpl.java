package com.codegym.Service.impl;

import com.codegym.Model.HotelService;
import com.codegym.Repositorys.HotelServiceRepositorys;
import com.codegym.Service.HotelServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelServiceService {

    @Autowired
    HotelServiceRepositorys hotelServiceRepositorys;

    @Override
    public void save(HotelService hotelService){
        hotelServiceRepositorys.save(hotelService);
    }

    @Override
    public HotelService findById(String id) {
        return hotelServiceRepositorys.findById(id).orElse(null);
    }

    @Override
    public List<HotelService> findAll() {
        return hotelServiceRepositorys.findAll();
    }

    @Override
    public Page<HotelService> findAll(Pageable pageable) {
        return hotelServiceRepositorys.findAll(pageable);
    }

    @Override
    public Page<HotelService> findAllByName(Pageable pageable,String nameService) {
        return hotelServiceRepositorys.findAllByNameServiceContaining(pageable,nameService);
    }

    @Override
    public void remove(String id) {
        hotelServiceRepositorys.deleteById(id);
    }


}
