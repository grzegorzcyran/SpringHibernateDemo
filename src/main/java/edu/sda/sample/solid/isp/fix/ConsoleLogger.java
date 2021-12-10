package edu.sda.sample.solid.isp.fix;

public class ConsoleLogger implements Logger {

    @Override
    public void writeMessage(String message) {
        System.out.println("Writing msg: " + message + " to console.");
    }
}
