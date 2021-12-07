package edu.sda.sample.solid.ocp.fix;

public class FileLogger implements MessageLogger {

    @Override
    public void log(String message) throws Exception {
        System.out.println("Sending logs: " + message + " to some file!");
    }
}
