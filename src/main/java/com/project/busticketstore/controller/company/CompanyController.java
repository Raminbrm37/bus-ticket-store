package com.project.busticketstore.controller.company;


import com.project.busticketstore.dto.CompanyDto;
import com.project.busticketstore.model.Company;
import com.project.busticketstore.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CompanyDto> getCreateCompany(@Valid @RequestBody CompanyDto companyDto) {

        return ResponseEntity.ok(modelMapper.map(
                companyService.createCompany(
                        modelMapper.map(
                                companyDto, Company.class)), CompanyDto.class));
    }

    @GetMapping(value = "/view/{id:\\d+}")
    public ResponseEntity<CompanyDto> getViewCompany(@PathVariable Long id){

        return ResponseEntity.ok(modelMapper.map(companyService.findById(id),CompanyDto.class));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CompanyDto>> getAllCompany(){
        List<CompanyDto> list= new ArrayList<>();
                companyService.findAll().forEach(
                        company -> list.add(modelMapper.map(company,CompanyDto.class)));
        return ResponseEntity.ok(
              list
        );
    }


}
