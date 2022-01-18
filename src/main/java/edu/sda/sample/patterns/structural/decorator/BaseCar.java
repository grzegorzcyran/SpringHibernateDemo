package edu.sda.sample.patterns.structural.decorator;

public class BaseCar implements Car {

    private String color;

    public BaseCar(String color) {
        this.color = color;
    }

    @Override
    public void assemble() {
        System.out.println("Basic car with color = " + color);
    }
}
