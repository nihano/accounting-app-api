package com.accounting.accountingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.bind.v2.TODO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String confirmPassword;
    private String firstname;
    private String lastname;
    private String phone;
    private RoleDto role;
    private CompanyDto company;

    //TODO:    (should be true if this user is only admin of any company.)
    private Boolean isOnlyAdmin;

}

