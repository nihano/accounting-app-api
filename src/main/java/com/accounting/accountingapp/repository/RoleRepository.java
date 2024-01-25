package com.accounting.accountingapp.repository;

import com.accounting.accountingapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByDescription(String description);
}
