package com.accounting.accountingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {


    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipcode;
}
