package com.codegym.Service.impl;

import com.codegym.Model.HotelServiceType;
import com.codegym.Repositorys.HotelServiceTypeRepositorys;
import com.codegym.Service.HotelServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceTypeImpl implements HotelServiceTypeService {

    @Autowired
    HotelServiceTypeRepositorys hotelServiceTypeRepositorys;

    @Override
    public List<HotelServiceType> findAll() {
        return hotelServiceTypeRepositorys.findAll();
    }
}
