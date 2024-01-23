package com.accounting.accountingapp.service;

import com.accounting.accountingapp.dto.CompanyDto;
import com.accounting.accountingapp.entity.Company;
import com.accounting.accountingapp.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {

    CompanyDto findById(Long Id);
    List<CompanyDto> listCompanies();
    void save(CompanyDto companyDto);
    void update(CompanyDto companyDto, Long id);

    void activateCompany(Long id);
    void deactivateCompany(Long id);
    void delete(Long id);
    CompanyDto getCompanyById(Long id);



}
