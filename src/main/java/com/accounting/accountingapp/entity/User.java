package com.accounting.accountingapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private boolean enabled;
    /// many-to-one / will be seen under "role_id" column on the "users" table
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    // many-to-one / will be seen under "company_id" column on the "users" table
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
