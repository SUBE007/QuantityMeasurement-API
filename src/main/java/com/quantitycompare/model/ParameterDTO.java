package com.quantitycompare.model;

public class ParameterDTO {
    String unit1;
    Double val1;
    String unit2;
    Double val2;

    public ParameterDTO(String unit1, Double val1, String unit2, Double val2){
        this.unit1 = unit1;
        this.val1 = val1;
        this.unit2 = unit2;
        this.val2 = val2;
    }

    public Double getVal1() {
        return val1;
    }

    public void setVal1(Double val1) {
        this.val1 = val1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public Double getVal2() {
        return val2;
    }

    public void setVal2(Double val2) {
        this.val2 = val2;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }
}
