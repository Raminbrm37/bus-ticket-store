package com.project.busticketstore.repository;

import com.project.busticketstore.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByName(String name);
}
