package com.quantitymeasurement;

import com.quantitycompare.controller.QuantityMeasurmentController;
import com.quantitycompare.model.ParameterDTO;
import com.quantitycompare.services.ConvertStringParameterIntoEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class QuantityMeasurementApplicationTests {
    private String unit2;
    private Double val1;
    private String unit1;
    private Double val2;
    private ParameterDTO parameterBody;

    @Mock
    ConvertStringParameterIntoEnum stringParameterIntoEnum;
    @InjectMocks
    QuantityMeasurmentController quantityMeasurementController;

    @BeforeEach
    void setUp() {
        unit2="CENTIMETER";
        val1= 2.0;
        unit1="CENTIMETER";
        val2=2.0;
        parameterBody = new ParameterDTO(unit1,val1,unit2,val2);

    }

    @Test
    void givenTwoSameUnits_WhenPassedFromControllerToCompare_ShouldReturnTrueStatement() {
        when(stringParameterIntoEnum.doCompare(unit1,val1,unit2,val2)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true");
        String compareUnits = quantityMeasurementController.compareUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("is 2.0CENTIMETER equal to 2.0CENTIMETER? : true",compareUnits);
    }

    @Test
    void givenTwoDifferentUnits_WhenPassedFromControllerToCompare_ShouldReturnFalseStatement() {
        unit1="CENTIMETER";
        val1=2.0;
        unit2="YARD";
        val2=2.0;
        when(stringParameterIntoEnum.doCompare(unit1,val1,unit2,val2)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : false");
        String compareUnits = quantityMeasurementController.compareUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("is 2.0CENTIMETER equal to 2.0YARD? : false",compareUnits);
    }

    @Test
    void givenTwoUnits_WhenPassedFromControllerToAdd_ShouldReturnAddition() {
        unit1="CENTIMETER";
        val1=2.0;
        unit2="CENTIMETER";
        val2=2.0;
        when(stringParameterIntoEnum.doAdd(unit1,val1,unit2,val2)).thenReturn("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0);
        String compareUnits = quantityMeasurementController.addUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0,compareUnits);
    }

    @Test
    void givenBodyOfParam_WhenPassedFromControllerToAdd_ShouldReturnAddition() {
        when(stringParameterIntoEnum.doAddByBody(parameterBody)).thenReturn("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0);
        String compareUnits = quantityMeasurementController.addUnits(parameterBody);
        Assert.assertEquals("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0,compareUnits);
    }

    @Test
    void givenBodyOfParam_WhenPassedFromControllerToCompare_ShouldReturn() {
        when(stringParameterIntoEnum.doCompareByBody(parameterBody)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true");
        String compareUnits = quantityMeasurementController.compareUnits(parameterBody);
        Assert.assertEquals("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true",compareUnits);
    }

}
