package edu.sda.sample.patterns.behavioral.strategy;

public class Demo {
    public static void main(String[] args) {
        Travel travel = new Travel("Rzeszów", "Bieszczady");

        travel.setTravelPlan(new WalkStrategy(false));

        travel.setTravelPlan(new CarStrategy(false, true));

        travel.setTravelPlan(new WalkStrategy(true));
    }
}
