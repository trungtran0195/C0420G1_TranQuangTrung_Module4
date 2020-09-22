package com.codegym.Repositorys;

import com.codegym.Model.HotelServiceRentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelServiceRentTypeRepositorys extends JpaRepository<HotelServiceRentType, Long> {
}
