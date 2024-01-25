package com.accounting.accountingapp.service.impl;

import com.accounting.accountingapp.dto.UserDto;
import com.accounting.accountingapp.entity.User;
import com.accounting.accountingapp.mapper.MapperUtil;
import com.accounting.accountingapp.repository.UserRepository;
import com.accounting.accountingapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public UserDto findByUsername(String username) {
        //no security right now hardcoded
        User user = userRepository.findByUsername("root@cydeo.com");
        return mapperUtil.convert(user, new UserDto());
    }

    @Override
    public List<UserDto> listUsers() {
        //no security right now hardcoded
        UserDto userDto = findByUsername("root@cydeo.com");
        List<UserDto> list = new ArrayList<>();

        //  4. Admin can only see his/her company's users
        if (userDto.getRole().getDescription().equalsIgnoreCase("admin")) {
            list = userRepository.findAllOrderedByCompanyAndRole().stream()
                    .filter(user -> user.getCompany().getTitle().equals(userDto.getCompany().getTitle()))
                    .map(user -> mapperUtil.convert(user, new UserDto()))
                    .collect(Collectors.toList());
            //     3. Root User can list only admins of all companies
        } else if (userDto.getRole().getDescription().equalsIgnoreCase("root user")) {
            list = userRepository.findAllOrderedByCompanyAndRole().stream()
                    .filter(user -> user.getRole().getDescription().equalsIgnoreCase("admin"))
                    .map(user -> mapperUtil.convert(user, new UserDto()))
                    .collect(Collectors.toList());
        }

        return list;
    }

}
