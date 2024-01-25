package com.accounting.accountingapp.service;

import com.accounting.accountingapp.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findByUsername(String username);
    List<UserDto> listUsers();
//    boolean isOnlyAdmin();
    boolean isAdmin(UserDto userDto);
    boolean isRoot(UserDto userDto);


}
