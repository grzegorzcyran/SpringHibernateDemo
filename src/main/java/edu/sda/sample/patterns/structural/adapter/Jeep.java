package edu.sda.sample.patterns.structural.adapter;

public class Jeep extends AmericanCar {
    private String name;

    public Jeep(String name, double speed) {
        this.speed = speed;
        this.name = name;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
