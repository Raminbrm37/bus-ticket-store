package com.project.busticketstore.service;

import com.project.busticketstore.dto.CompanyDto;
import com.project.busticketstore.dto.UserDto;
import com.project.busticketstore.model.Company;
import com.project.busticketstore.model.User;
import com.project.busticketstore.util.exception.CompanyAlreadyException;
import com.project.busticketstore.util.exception.UserAlreadyExistException;

public interface CompanyService extends BaseEntityService<Company,Long> {
    Company createCompany(Company Company)throws CompanyAlreadyException;
    Boolean checkIfCompanyExist(String name);
}
