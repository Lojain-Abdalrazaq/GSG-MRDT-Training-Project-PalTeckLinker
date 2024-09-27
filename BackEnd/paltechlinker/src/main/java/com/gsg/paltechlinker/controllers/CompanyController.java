package com.gsg.paltechlinker.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.gsg.paltechlinker.domain.dto.CompanyDto;
import com.gsg.paltechlinker.domain.entities.CompanyEntity;
import com.gsg.paltechlinker.mappers.Mapper;
import com.gsg.paltechlinker.services.CompanyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class CompanyController {

    private static final String COMPANIES = "/companies", COMPANIES_ID = "companies/{id}";

    private CompanyService companyService;
    private Mapper<CompanyEntity, CompanyDto> mapper;


    public CompanyController(CompanyService companyService, Mapper<CompanyEntity, CompanyDto> mapper) {
        this.companyService = companyService;
        this.mapper = mapper;
    }
    

    @PostMapping(COMPANIES)
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        CompanyEntity companyEntity = mapper.mapFrom(companyDto);
        CompanyEntity savedCompanyEntity = companyService.save(companyEntity);
        return new ResponseEntity<>(mapper.mapTo(savedCompanyEntity), HttpStatus.CREATED);
    }
    
    
}
