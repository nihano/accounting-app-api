package com.accounting.accountingapp.dto;

import com.accounting.accountingapp.enums.CompanyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {

    @JsonIgnore
    private Long id;
    private String title;
    private String phone;
    private String website;
    private AddressDto address;
    private CompanyStatus companyStatus;

}
