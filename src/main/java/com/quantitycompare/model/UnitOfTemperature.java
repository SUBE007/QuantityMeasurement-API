package com.quantitycompare.model;

public enum UnitOfTemperature implements IUnit {
    FAHRENHEIT(32.0), CELSIUS(1.0);
    private final double valueOfTemperature;

    UnitOfTemperature(double valueOfTemperature) {
        this.valueOfTemperature = valueOfTemperature;
    }

    @Override
    public Double convertValue(Double valueOfUnit) {
        if (this.equals(FAHRENHEIT))
            return (valueOfUnit - this.valueOfTemperature) * 5 / 9;
        return this.valueOfTemperature * valueOfUnit;
    }
}
