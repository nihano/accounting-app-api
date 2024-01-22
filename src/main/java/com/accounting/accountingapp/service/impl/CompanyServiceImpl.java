package com.accounting.accountingapp.service.impl;

import com.accounting.accountingapp.dto.AddressDto;
import com.accounting.accountingapp.dto.CompanyDto;
import com.accounting.accountingapp.entity.Address;
import com.accounting.accountingapp.entity.Company;
import com.accounting.accountingapp.enums.CompanyStatus;
import com.accounting.accountingapp.mapper.MapperUtil;
import com.accounting.accountingapp.repository.AddressRepository;
import com.accounting.accountingapp.repository.CompanyRepository;
import com.accounting.accountingapp.service.AddressService;
import com.accounting.accountingapp.service.CompanyService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    ;
    private final AddressRepository addressRepository;
    private final AddressService addressService;
    private final MapperUtil mapperUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository, AddressRepository addressRepository, AddressService addressService, MapperUtil mapperUtil) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
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

//    Moved method to AddressServiceImp to reuse
//        Address address = mapperUtil.convert(companyDto.getAddress(), new Address());
//        Optional<Address> existingAddress = addressRepository.findByAddressDetails(
//                address.getAddressLine1(),
//                address.getAddressLine2(),
//                address.getCity(),
//                address.getState(),
//                address.getCountry(),
//                address.getZipCode()
//        );
//
//        if (existingAddress.isPresent()) {
//            address = existingAddress.get();
//        } else {
//            addressRepository.save(address);
//        }

        //check if the address already exists in the DB and get the existing or create new one
        log.info("addressDto: {}", companyDto.getAddress());
        Address address = addressService.createOrUpdateAddress(companyDto.getAddress());
        log.info("address: {} {}", address," id: "+ address.getId());

        company.setAddress(address);
        companyRepository.save(company);
    }



}
