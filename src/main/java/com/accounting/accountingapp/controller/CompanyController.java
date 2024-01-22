package com.accounting.accountingapp.controller;

import com.accounting.accountingapp.dto.CompanyDto;
import com.accounting.accountingapp.dto.ResponseWrapper;
import com.accounting.accountingapp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/create")
    public ResponseEntity<ResponseWrapper> getCompanies(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Companies successfully retrieved", companyService.listCompanies()));
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createCompany(@RequestBody CompanyDto companyDto){

        companyService.save(companyDto);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully created", companyDto));
    }

}
