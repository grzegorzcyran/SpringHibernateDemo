package edu.sda.sample.patterns.behavioral.strategy;

public class WalkStrategy implements TravelStrategy {

    boolean includeTouristPaths;

    public WalkStrategy(boolean includeTouristPaths) {
        this.includeTouristPaths = includeTouristPaths;
    }

    @Override
    public void setTravelPlan(String from, String to) {
        StringBuilder plan = new StringBuilder("Travel by foot from ")
                .append(from)
                .append(" to ")
                .append(to)
                .append(includeTouristPaths ? " including tourist paths" : "")
                .append(".");
        System.out.println(plan);
    }
}
