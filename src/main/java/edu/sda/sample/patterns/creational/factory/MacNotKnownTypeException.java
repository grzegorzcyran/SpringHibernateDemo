package edu.sda.sample.patterns.creational.factory;

public class MacNotKnownTypeException extends IllegalArgumentException {
    public MacNotKnownTypeException(String type) {
        super("Don't know anything of Mac type " + type);
    }
}
