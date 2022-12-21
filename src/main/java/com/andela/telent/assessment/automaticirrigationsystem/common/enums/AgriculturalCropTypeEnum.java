package com.andela.telent.assessment.automaticirrigationsystem.common.enums;

public enum AgriculturalCropTypeEnum {
    MAIZE(1_000_000),
    FORAGE_CROPS(100),
    FIBER_CROPS(100),
    OIL_CROPS(10000),
    FIBRE_CROPS(100),
    ORNAMENTAL_CROPS(1),
    INDUSTRIAL_CROPS(1),
    ANNUAL_CROPS(1),
    BIENNIAL_CROPS(1);

    private final float amountOfWater;

    AgriculturalCropTypeEnum(float amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public float getAmountOfWater() {
        return amountOfWater;
    }
}
