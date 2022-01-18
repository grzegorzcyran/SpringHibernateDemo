package edu.sda.sample.patterns.structural.decorator;

public abstract class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        System.out.println("Abstract assemble");
        this.car.assemble();
    }
}
