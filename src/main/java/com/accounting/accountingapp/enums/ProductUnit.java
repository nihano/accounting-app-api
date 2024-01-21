package com.accounting.accountingapp.enums;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public enum ProductUnit {
    LBS("Libre"), GALLON("Gallon"), PCS("Pieces"), KG("Kilogram"), METER("Meter"), INCH("Inch"), FEET("Feet");

    private String value;

    ProductUnit(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }

}
