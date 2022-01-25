package edu.sda.sample.patterns.structural.adapter;

public abstract class AmericanCar implements AmericanMovable {
    protected double speed;

    public double getSpeedKMH() {
        return speed * SpeedConverter.MILES_TO_KILOMETERS.getConverter();
    }
}
