package edu.sda.sample.solid.ocp.fix;

public class ConsoleLogger implements MessageLogger{

    /**
     * Poza metodą log pewnie jakaś definicja ConsoleLoggera (gdzie jest ta konsola do której piszemy)
     */

    @Override
    public void log(String message) throws Exception {
        System.out.println("Logging " + message + " to console");
    }
}
