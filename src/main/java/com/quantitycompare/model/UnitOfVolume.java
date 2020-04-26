package com.quantitycompare.model;

public enum UnitOfVolume implements IUnit {
    GALLON(3.78), LITRE(1.0), MILLILITRE(0.001);

    public final double valueOfVolume;

    UnitOfVolume(double value)
    {
        this.valueOfVolume = value;
    }

    @Override
    public Double convertValue(Double valueOfUnit)
    {
        return this.valueOfVolume * valueOfUnit;
    }
}
