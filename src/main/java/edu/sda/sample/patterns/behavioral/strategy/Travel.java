package edu.sda.sample.patterns.behavioral.strategy;

public class Travel {
    private String source;
    private String destination;

    public Travel(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public void setTravelPlan(TravelStrategy strategy) {
        strategy.setTravelPlan(source, destination);
    }
}
