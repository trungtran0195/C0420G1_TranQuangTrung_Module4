package com.codegym.Repositorys;

import com.codegym.Model.ContractExtraService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ContractExtraService,Long> {
}
