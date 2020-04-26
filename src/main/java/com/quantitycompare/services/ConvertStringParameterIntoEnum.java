package com.quantitycompare.services;


import com.quantitycompare.exception.QuantityMeasurementException;
import com.quantitycompare.model.IUnit;
import com.quantitycompare.model.ParameterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertStringParameterIntoEnum {
    IUnit unitFirst, unitSecond;


    @Autowired
    UnitContainer unitContainer;

    @Autowired
    QuantityMeasurement quantityMeasurement;//=new QuantityMeasurement();

    public String doCompare(String unit1, Double val1, String unit2, Double val2) {
        try {
            unitFirst = unitContainer.getUnit(unit1);
            unitSecond = unitContainer.getUnit(unit2);
            boolean compare = quantityMeasurement.compare(unitFirst, val1, unitSecond, val2);
            return "is "+val1 + unit1 + " equal to " + val2 + unit2 +"? :"+ compare;
        } catch (QuantityMeasurementException e) {
            return "something Went wrong....." + "<br><br>" + e.type;
        }
    }

    public String doAdd(String unit1, Double val1, String unit2, Double val2) {
        try {
            unitFirst = unitContainer.getUnit(unit1);
            unitSecond = unitContainer.getUnit(unit2);
            Double additionOfTwoUnits = quantityMeasurement.additionOfTwoUnits(unitFirst, val1, unitSecond, val2);
            return "Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to " + additionOfTwoUnits;
        } catch (QuantityMeasurementException e) {
            return "something Went wrong....." + "<br><br>" + e.type;
        }
    }

    public String doCompareByBody(ParameterDTO parameterDTO) {
        return doCompare(parameterDTO.getUnit1(),parameterDTO.getVal1(),parameterDTO.getUnit2(),parameterDTO.getVal2());
    }

    public String doAddByBody(ParameterDTO parameterDTO) {
        return doAdd(parameterDTO.getUnit1(),parameterDTO.getVal1(),parameterDTO.getUnit2(),parameterDTO.getVal2());
    }


}
