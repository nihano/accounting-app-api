package com.accounting.accountingapp.service.impl;


import com.accounting.accountingapp.dto.CompanyDto;
import com.accounting.accountingapp.entity.Address;
import com.accounting.accountingapp.entity.Company;
import com.accounting.accountingapp.enums.CompanyStatus;
import com.accounting.accountingapp.mapper.MapperUtil;
import com.accounting.accountingapp.repository.AddressRepository;
import com.accounting.accountingapp.repository.CompanyRepository;
import com.accounting.accountingapp.service.AddressService;
import com.accounting.accountingapp.service.CompanyService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressService addressService;
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository, AddressService addressService, AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.companyRepository = companyRepository;
        this.addressService = addressService;
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public CompanyDto findById(Long Id) {

        Company company = companyRepository.findById(Id).get();
        return mapperUtil.convert(company, new CompanyDto());
    }

    @Override
    public List<CompanyDto> listCompanies() {

        List<Company> companies = companyRepository.listCompaniesByStatus();
        return companies.stream()
                .map(company -> mapperUtil.convert(company, new CompanyDto()))
                .collect(Collectors.toList());

    }

    @Override
    public void save(CompanyDto companyDto) {

        companyDto.setCompanyStatus(CompanyStatus.PASSIVE);
        Company company = mapperUtil.convert(companyDto, new Company());

        log.info("addressDto: {}", companyDto.getAddress());

        //check if the address already exists in the DB and get the existing or create new one
        Address address = addressService.createOrUpdateAddress(companyDto.getAddress());

        log.info("address: {} {}", address," id: "+ address.getId());

        company.setAddress(address);
        companyRepository.save(company);
    }

    @Override
    public void update(CompanyDto companyDto,Long id){
        Company company=companyRepository.findById(id).get();
        log.info("Company in DB:{}",company);
        company.setCompanyStatus(companyDto.getCompanyStatus());
        company.setTitle(companyDto.getTitle());
        company.setWebsite(companyDto.getWebsite());
        company.setPhone(companyDto.getPhone());

        Address address=addressService.createOrUpdateAddress(companyDto.getAddress());

        log.info("AddressDto:{}",companyDto.getAddress());
        log.info("Address saved in the DB:{}{}",address,"primary_key: "+address.getId());

        company.setAddress(address);

        log.info("Address updated in company:{}{}{}",company.getAddress(),"company_id"+company.getId(),"address_id:"+company.getAddress().getId());

        companyRepository.save(company);
    }


    @Override
    public void activateCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Company does not exist"));
        if (company.getCompanyStatus().equals(CompanyStatus.PASSIVE)) {
            company.setCompanyStatus(CompanyStatus.ACTIVE);
        }

        companyRepository.save(company);
    }

    @Override
    public void deactivateCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Company does not exist"));
        if (company.getCompanyStatus().equals(CompanyStatus.ACTIVE)) {
            company.setCompanyStatus(CompanyStatus.PASSIVE);
        }

        companyRepository.save(company);
    }




}
