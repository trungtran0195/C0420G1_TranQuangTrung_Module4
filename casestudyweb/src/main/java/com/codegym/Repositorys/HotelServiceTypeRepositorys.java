package com.codegym.Repositorys;

import com.codegym.Model.HotelServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelServiceTypeRepositorys extends JpaRepository<HotelServiceType, Long> {
}
