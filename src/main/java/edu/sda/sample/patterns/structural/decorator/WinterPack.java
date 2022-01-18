package edu.sda.sample.patterns.structural.decorator;

public class WinterPack extends CarDecorator {
    boolean electricMirrors;
    boolean heatedSeats;

    public WinterPack(Car car, boolean electricMirrors, boolean heatedSeats) {
        super(car);
        this.electricMirrors = electricMirrors;
        this.heatedSeats = heatedSeats;
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Winter pack" +
                        (electricMirrors ? " with electric mirrors" : "") +
                        (heatedSeats ? " with heated seats" : "") +
                "."
                );
    }
}
