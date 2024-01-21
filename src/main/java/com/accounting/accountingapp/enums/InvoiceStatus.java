package com.accounting.accountingapp.enums;

public enum InvoiceStatus {

    AWAITING_APPROVAL("Awaiting Approval"), APPROVED("Approved");
    private String value;

    InvoiceStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
