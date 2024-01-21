package com.accounting.accountingapp.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="roles")
public class Role extends BaseEntity {
    private String description;


}
