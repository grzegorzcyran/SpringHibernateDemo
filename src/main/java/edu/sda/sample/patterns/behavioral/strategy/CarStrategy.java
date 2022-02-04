package edu.sda.sample.patterns.behavioral.strategy;

public class CarStrategy implements TravelStrategy {
    private boolean includePaidMotorways;
    private boolean includeFieldRoads;

    public CarStrategy(boolean includePaidMotorways, boolean includeFieldRoads) {
        this.includePaidMotorways = includePaidMotorways;
        this.includeFieldRoads = includeFieldRoads;
    }

    @Override
    public void setTravelPlan(String from, String to) {
        StringBuilder plan = new StringBuilder("Traveling from ")
                .append(from)
                .append(" to ")
                .append(to)
                .append(includePaidMotorways ? " including paid roads" : "")
                .append(includeFieldRoads ? " including field roads" : "")
                .append(".");
        System.out.println(plan);
    }
}
