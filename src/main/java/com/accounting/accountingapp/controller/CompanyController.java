package com.accounting.accountingapp.controller;

import com.accounting.accountingapp.dto.CompanyDto;
import com.accounting.accountingapp.dto.ResponseWrapper;
import com.accounting.accountingapp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/list")
    public ResponseEntity<ResponseWrapper> getCompanies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Companies successfully retrieved", companyService.listCompanies()));
    }

    @GetMapping("/create")
    public ResponseEntity<ResponseWrapper> getCompany(@RequestBody CompanyDto companyDto) {

        companyService.save(companyDto);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully created", companyDto));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createCompany(@RequestBody CompanyDto companyDto) {

        companyService.save(companyDto);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully created", companyDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseWrapper> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyDto companyDto) {
        companyService.update(companyDto, id);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully updated", companyDto));
    }

    @GetMapping("/activate/{id}")
    public ResponseEntity<ResponseWrapper> activateCompany(@PathVariable("id") Long id) {
        companyService.activateCompany(id);
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(new ResponseWrapper("Company status is successfully updated as 'Active' ", HttpStatus.OK));
    }

    @GetMapping("/deactivate/{id}")
    public ResponseEntity<ResponseWrapper> deactivateCompany(@PathVariable("id") Long id) {
        companyService.deactivateCompany(id);
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(new ResponseWrapper("Company status is successfully updated as 'Passive'", HttpStatus.OK));
    }


}
