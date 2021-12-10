package edu.sda.sample.solid.isp.fix;

@FunctionalInterface
public interface Logger {

    void writeMessage(String message);
}
