package com.quantitycompare.services;

import com.quantitycompare.exception.QuantityMeasurementException;
import com.quantitycompare.model.IUnit;
import com.quantitycompare.model.UnitOfTemperature;

public class QuantityMeasurement {

    private Double value;
    private IUnit unit;

    public QuantityMeasurement() {
    }

    public QuantityMeasurement(Double value, IUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(IUnit unitFirst, Double firstParameter, IUnit unitSecond, Double secondParameter) throws QuantityMeasurementException {
        if (!unitFirst.getClass().equals(unitSecond.getClass()))
            throw new QuantityMeasurementException("parameter units are of two different type", QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE);
        Double firstValue = unitFirst.convertValue(firstParameter);
        Double secondValue = unitSecond.convertValue(secondParameter);
        return (Double.compare(Math.round(firstValue), Math.round(secondValue)) == 0);
    }

    public Double additionOfTwoUnits(IUnit unitFirst, Double firstParameter, IUnit unitSecond, Double secondParameter) throws QuantityMeasurementException {
        if (unitFirst.getClass().getName().equals(UnitOfTemperature.class.getName())
                | unitSecond.getClass().getName().equals(UnitOfTemperature.class.getName())
                | !unitFirst.getClass().equals(unitSecond.getClass()))
            throw new QuantityMeasurementException("parameter units cant be added", QuantityMeasurementException.ExceptionType.UNIT_NOT_ADDABLE);
        Double firstValue = unitFirst.convertValue(firstParameter);
        Double secondValue = unitSecond.convertValue(secondParameter);
        return (firstValue + secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement quantityMeasurement = (QuantityMeasurement) o;
        return Double.compare(quantityMeasurement.value, value) == 0 &&
                unit == quantityMeasurement.unit;
    }
}
