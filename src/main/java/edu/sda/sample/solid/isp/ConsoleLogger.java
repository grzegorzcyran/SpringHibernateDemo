package edu.sda.sample.solid.isp;

import java.util.Collection;

public class ConsoleLogger implements Logger {

    @Override
    public void writeMessage(String message) {
        System.out.println("Adding new comm: " + message + " to console.");
    }

    @Override
    public Collection<String> readMessages() {
        System.out.println("Reading messages from console is impossible");
        throw new UnsupportedOperationException();
    }
}
