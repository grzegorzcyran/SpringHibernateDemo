package edu.sda.sample.patterns.creational.factory;

public class MacBookFactory {

    public static MacBook getMac(String type, String name, String disc, int memory) {

        if(type.equalsIgnoreCase("Air")) {
            return new MacBookAir(name, disc, memory);
        } else if (type.equalsIgnoreCase("Pro")) {
            return new MacBookPro(name, disc, memory);
        } else {
            throw new MacNotKnownTypeException(type);
        }
    }
}
