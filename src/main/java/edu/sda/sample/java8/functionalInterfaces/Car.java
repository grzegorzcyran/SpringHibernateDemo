package edu.sda.sample.java8.functionalInterfaces;

public class Car {
    private String name;
    private String engine;

    public Car(String name, String engine) {
        System.out.println("Tworzę obiekt z nazwą: " + name + " i silnikiem " + engine);
        this.name = name;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }
}
