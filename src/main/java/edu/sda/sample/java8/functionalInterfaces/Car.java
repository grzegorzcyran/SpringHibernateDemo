package edu.sda.sample.java8.functionalInterfaces;

public class Car implements Comparable<Car> {
    private String name;
    private String engine;
    private int noOfSeats;

    public Car(String name, String engine) {
        System.out.println("Tworzę obiekt z nazwą: " + name + " i silnikiem " + engine);
        this.name = name;
        this.engine = engine;
    }

    public Car(String name, String engine, int noOfSeats) {
        this.name = name;
        this.engine = engine;
        this.noOfSeats = noOfSeats;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    @Override
    public int compareTo(Car o) {
        return this.engine.compareTo(o.getEngine());
    }
}
