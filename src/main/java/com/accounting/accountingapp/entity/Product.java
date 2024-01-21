package com.accounting.accountingapp.entity;


import com.accounting.accountingapp.enums.ProductUnit;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private int quantityInStock;
    private int lowLimitAlert;
    @Enumerated(EnumType.STRING)
    private ProductUnit productUnit;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
