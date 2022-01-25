package edu.sda.sample.patterns.structural.adapter;

public enum SpeedConverter {

    MILES_TO_KILOMETERS(1.609344),
    KILOMETERS_TO_MILES(0.6213712);

    private double converter;

    SpeedConverter(double converter) {
        this.converter = converter;
    }

    public double getConverter() {
        return converter;
    }
}
