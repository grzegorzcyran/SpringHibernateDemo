package edu.sda.sample.solid.ocp.fix;

public class DatabaseLogger implements MessageLogger {

    //Jakaś definicja gdzie ta baza do której logujemy

    @Override
    public void log(String message) throws Exception {
        System.out.println("Sending " + message + " to DB");
    }
}
