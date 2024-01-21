package com.accounting.accountingapp.service;

import com.accounting.accountingapp.dto.AddressDto;
import com.accounting.accountingapp.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    void save(AddressDto addressDto);

    public Address createOrUpdateAddress(AddressDto addressDto);
}
