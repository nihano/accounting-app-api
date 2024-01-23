package com.accounting.accountingapp.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "invoice_products")
public class InvoiceProduct extends BaseEntity{
    private int quantity;
    private BigDecimal price;
    private int tax;
    private BigDecimal profitLoss;
    private int remainingQty;
    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
