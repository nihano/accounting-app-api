package com.accounting.accountingapp.service.impl;

import com.accounting.accountingapp.dto.UserDto;
import com.accounting.accountingapp.entity.Company;
import com.accounting.accountingapp.entity.Role;
import com.accounting.accountingapp.entity.User;
import com.accounting.accountingapp.mapper.MapperUtil;
import com.accounting.accountingapp.repository.CompanyRepository;
import com.accounting.accountingapp.repository.RoleRepository;
import com.accounting.accountingapp.repository.UserRepository;
import com.accounting.accountingapp.service.CompanyService;
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
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil, CompanyService companyService, CompanyRepository companyRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;

        this.companyRepository = companyRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto findByUsername(String username) {
        //TODO: no security right now hardcoded
        User user = userRepository.findByUsername("admin@greentech.com");
        return mapperUtil.convert(user, new UserDto());
    }

    @Override
    public List<UserDto> listUsers() {
        //TODO: no security right now hardcoded
        UserDto userDto = findByUsername("admin@greentech.com");
        List<UserDto> list = new ArrayList<>();

        //  4. Admin can only see his/her company's users
        if (isAdmin(userDto)) {
            list = userRepository.findAllOrderedByCompanyAndRole().stream()
                    .filter(user -> user.getCompany().getTitle().equals(userDto.getCompany().getTitle()))
                    .map(user -> mapperUtil.convert(user, new UserDto()))
                    .collect(Collectors.toList());
            //     3. Root User can list only admins of all companies
        } else if (isRoot(userDto)) {
            list = userRepository.findAllOrderedByCompanyAndRole().stream()
                    .filter(user -> user.getRole().getDescription().equalsIgnoreCase("admin"))
                    .map(user -> mapperUtil.convert(user, new UserDto()))
                    .collect(Collectors.toList());
        }

        log.info("User Role: {}", userDto.getRole().getDescription());
        log.info("User Company: {}", userDto.getCompany().getTitle());
        log.info("Companies: {}", list.stream().map(userDto1 -> userDto1.getCompany().getTitle()).collect(Collectors.toList()));

        return list;
    }

    @Override
    public boolean isAdmin(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        return (user.getRole().getDescription().equalsIgnoreCase("admin"));
    }

    @Override
    public boolean isRoot(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        return (user.getRole().getDescription().equalsIgnoreCase("root user"));
    }

    @Override
    public void save(UserDto userDto) {
        //TODO: only root user or admin can create user. should i add restriction here or will it only come from html?
        Company company = companyRepository.findByTitle(userDto.getCompany().getTitle());
        Role role = roleRepository.findByDescription(userDto.getRole().getDescription());
        User user = new User();
        user.setCompany(company);
        user.setRole(role);
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());

        if (isOnlyAdmin(userDto)){
            userDto.setIsOnlyAdmin(true);
        }else {
            userDto.setIsOnlyAdmin(false);
        }

        userRepository.save(user);
    }

    @Override
    public boolean isOnlyAdmin(UserDto userDto) {
        String companyTitle = userDto.getCompany().getTitle();
        List<String> titles = userRepository.findAll().stream()
                .filter(user1 -> user1.getCompany().getTitle().equalsIgnoreCase(companyTitle))
                .map(user1 -> user1.getCompany().getTitle())
                .collect(Collectors.toList());
        return !titles.contains(companyTitle);
    }

}
