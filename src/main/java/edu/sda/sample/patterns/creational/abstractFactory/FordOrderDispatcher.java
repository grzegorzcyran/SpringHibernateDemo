package edu.sda.sample.patterns.creational.abstractFactory;

public class FordOrderDispatcher {

    public static Ford getFord(FordAbstractFactory factory) {
        return factory.createFord();
    }
}
