package edu.sda.sample.patterns.creational.abstractFactory;

import java.util.List;

public class FordFiesta extends Ford {
    private String name;
    private String engine;
    private String addons;

    public FordFiesta(String name, String engine, String addons) {
        this.name = name;
        this.engine = engine;
        this.addons = addons;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public String getAddons() {
        return addons;
    }

}
