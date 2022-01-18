package edu.sda.sample.patterns.structural.flyweight;

public class FordMustang {

    private String radio;
    private FordMustangBase mustangBase;

    public FordMustang(String color, String engine, String radio) {
        System.out.println(this.getClass().getSimpleName() + " konstruktor");
        mustangBase = FordMustangBaseFactory.getMustangBase(color, engine);
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "FordMustang{" +
                "radio='" + radio + '\'' +
                ", mustangBase=" + mustangBase +
                '}';
    }

    public String printMustangData() {
        return radio + " " + mustangBase.getColor() + " " + mustangBase.getEngine();
    }
}
