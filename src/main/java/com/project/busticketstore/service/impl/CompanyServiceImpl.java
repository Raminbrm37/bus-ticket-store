package com.project.busticketstore.service.impl;

import com.project.busticketstore.dto.CompanyDto;
import com.project.busticketstore.model.Company;
import com.project.busticketstore.repository.CompanyRepository;
import com.project.busticketstore.service.CompanyService;
import com.project.busticketstore.util.exception.CompanyAlreadyException;
import com.project.busticketstore.util.exception.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) throws CompanyAlreadyException {
       if (this.checkIfCompanyExist(company.getName())){
           throw new CompanyAlreadyException("company exist by name  :"+company.getName());
       }
        return companyRepository.save(company);
    }

    @Override
    public Boolean checkIfCompanyExist(String name) {
        return companyRepository.findByName(name)!=null;
    }

    @Override
    public Company save(Company entity) {
        return null;
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()->new CompanyNotFoundException("not found company via id : "+id));
    }

    @Override
    public List<Company> findAll() {

        return companyRepository.findAll();
    }

    @Override
    public Boolean remove(Long entity) {
        return null;
    }

    @Override
    public Boolean removeById(Company id) {
        return null;
    }
}
