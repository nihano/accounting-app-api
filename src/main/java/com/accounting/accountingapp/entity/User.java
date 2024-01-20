package com.accounting.accountingapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean enabled;
    /// many-to-one / will be seen under "role_id" column on the "users" table
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    // many-to-one / will be seen under "company_id" column on the "users" table
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
