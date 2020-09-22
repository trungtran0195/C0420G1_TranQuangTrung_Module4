package com.codegym.Service.impl;

import com.codegym.Model.HotelServiceRentType;
import com.codegym.Repositorys.HotelServiceRentTypeRepositorys;
import com.codegym.Service.HotelServiceRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceRentTypeImpl implements HotelServiceRentTypeService {

    @Autowired
    HotelServiceRentTypeRepositorys hotelServiceRentTypeRepositorys;

    @Override
    public List<HotelServiceRentType> findAll() {
        return hotelServiceRentTypeRepositorys.findAll();
    }
}
