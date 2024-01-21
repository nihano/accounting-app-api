package com.accounting.accountingapp.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseEntity {
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
