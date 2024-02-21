package com.accounting.accountingapp.service;

import com.accounting.accountingapp.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findByUsername(String username);
    List<UserDto> listUsers();
    boolean isAdmin(UserDto userDto);
    boolean isRoot(UserDto userDto);
    void save(UserDto userDto);
    boolean isOnlyAdmin(UserDto userDto);

    void update(UserDto userDto, Long id);


}
