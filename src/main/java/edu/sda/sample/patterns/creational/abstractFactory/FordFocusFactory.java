package edu.sda.sample.patterns.creational.abstractFactory;

public class FordFocusFactory implements FordAbstractFactory{

    String name;
    String engine;
    String addons;

    public FordFocusFactory(String name, String engine, String addons) {
        this.name = name;
        this.engine = engine;
        this.addons = addons;
    }

    @Override
    public Ford createFord() {
        return new FordFocus(name, engine, addons);
    }
}
