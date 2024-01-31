package com.accounting.accountingapp.enums;

public enum InvoiceType {

    PURCHASE("Purchase"), SALES("Sales");

    private String value;
    InvoiceType(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
