package com.quantitycompare.controller;

import com.quantitycompare.exception.QuantityMeasurementException;
import com.quantitycompare.model.UnitOfLength;
import com.quantitycompare.services.ConvertStringParameterIntoEnum;
import com.quantitycompare.services.QuantityMeasurement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MeasurementControllerTests {

    @Mock
    QuantityMeasurement quantityMeasurement;
    @InjectMocks
    ConvertStringParameterIntoEnum stringParameterIntoEnum;

    @Before
    public void setUp() {
        quantityMeasurement = mock(QuantityMeasurement.class);
        stringParameterIntoEnum = mock(ConvertStringParameterIntoEnum.class);
    }

    @Test
    public void name() {
        try {
            when(quantityMeasurement.compare(UnitOfLength.INCH,2.0, UnitOfLength.INCH,2.0)).thenReturn(true);
            String doCompare = stringParameterIntoEnum.doCompare("INCH", 2.0, "INCH", 2.0);
            Assert.assertEquals("is "+2.0 +"INCH equal to " + 2.0 +"INCH ? :",doCompare);
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

}
