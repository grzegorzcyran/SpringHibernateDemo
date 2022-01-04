package edu.sda.sample.patterns.creational.abstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        Ford fiesta1 = FordOrderDispatcher.getFord(new FordFiestaFactory("Fiesta 2022", "1.1", "winter pack"));
        Ford fiesta2 = FordOrderDispatcher.getFord(new FordFiestaFactory("Fiesta 2022", "0.9", ""));
        Ford focus1 = FordOrderDispatcher.getFord(new FordFocusFactory("Focus 2022", "1.6", "winter pack"));


    }
}
