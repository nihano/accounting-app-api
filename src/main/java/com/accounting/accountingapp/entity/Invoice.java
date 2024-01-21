package com.accounting.accountingapp.entity;


import com.accounting.accountingapp.enums.InvoiceStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity {
    private String invoiceNo;
    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientVendor clientVendor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
