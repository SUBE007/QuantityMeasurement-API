package com.quantitycompare.model;

public enum UnitOfWeights implements  IUnit{

    KILOGRAM(1.0), GRAM(0.001), TONNE(1000.0);

    private final double valueWeights;

    UnitOfWeights(double valueWeights)
    {
        this.valueWeights = valueWeights;
    }

    @Override
    public Double convertValue(Double valueOfUnit)
    {
        return this.valueWeights * valueOfUnit;
    }
}
