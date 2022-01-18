package edu.sda.sample.patterns.structural.flyweight;

public class FordMustangBase {
    private String color;
    private String engine;

    public FordMustangBase(String color, String engine) {
        System.out.println(this.getClass().getSimpleName() + " constructor " + color + " " + engine);
        this.color = color;
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "FordMustangBase{" +
                "color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
