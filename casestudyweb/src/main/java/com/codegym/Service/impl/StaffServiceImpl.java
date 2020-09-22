package com.codegym.Service.impl;

import com.codegym.Model.Staffs;
import com.codegym.Repositorys.StaffRepository;
import com.codegym.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staffs> findAll() {
        return staffRepository.findAll();
    }
}
