package com.accounting.accountingapp.service.impl;

import com.accounting.accountingapp.dto.AddressDto;
import com.accounting.accountingapp.entity.Address;
import com.accounting.accountingapp.mapper.MapperUtil;
import com.accounting.accountingapp.repository.AddressRepository;
import com.accounting.accountingapp.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final MapperUtil mapperUtil;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(MapperUtil mapperUtil, AddressRepository addressRepository) {
        this.mapperUtil = mapperUtil;
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(AddressDto addressDto) {
        Address address = mapperUtil.convert(addressDto, new Address());
        addressRepository.save(address);
    }

    @Override
    public Address createOrUpdateAddress(AddressDto addressDto) {

        //this method is to check if address is already exist in the DB
        //if address does not exist when updating it will create it in db and new foreign key in the company when updating
        Address address = mapperUtil.convert(addressDto, new Address());

        Optional<Address> existingAddress = addressRepository.findByAddressDetails(
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getZipCode()
        );

        if (existingAddress.isPresent()) {
            address = existingAddress.get();
        } else {
            addressRepository.save(address);
        }

        return address;
    }
}
