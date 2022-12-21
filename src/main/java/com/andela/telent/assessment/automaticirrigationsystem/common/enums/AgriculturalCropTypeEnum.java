package com.andela.telent.assessment.automaticirrigationsystem.common.enums;

public enum AgriculturalCropTypeEnum {
    MAIZE(1000),
    FORAGE_CROPS(2000),
    FIBER_CROPS(3000),
    OIL_CROPS(4000),
    FIBRE_CROPS(5000),
    ORNAMENTAL_CROPS(6000),
    INDUSTRIAL_CROPS(7000),
    ANNUAL_CROPS(8000),
    BIENNIAL_CROPS(9000);

    private final float amountOfWater;

    AgriculturalCropTypeEnum(float amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public float getAmountOfWater() {
        return amountOfWater;
    }
}
