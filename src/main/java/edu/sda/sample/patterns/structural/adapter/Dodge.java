package edu.sda.sample.patterns.structural.adapter;

public class Dodge extends AmericanCar {

    private String name;

    public Dodge(String name, double speed) {
        this.speed = speed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getSpeed() {
        System.out.println("Zwracam speed z klasy " + Dodge.class.getSimpleName());
        return speed;
    }
}
