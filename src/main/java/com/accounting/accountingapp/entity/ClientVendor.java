package com.accounting.accountingapp.entity;

import com.accounting.accountingapp.enums.ClientVendorType;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "client_vendors")
public class ClientVendor extends BaseEntity {

    private String clientVendorName;
    private String phone;
    private String website;
    private ClientVendorType clientVendorType;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
