package com.accounting.accountingapp.repository;

import com.accounting.accountingapp.dto.UserDto;
import com.accounting.accountingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM users u " +
            "JOIN roles r ON u.role_id = r.id " +
            "JOIN companies c ON u.company_id = c.id " +
            "ORDER BY c.title, r.description", nativeQuery = true)
    List<User> findAllOrderedByCompanyAndRole();


}
