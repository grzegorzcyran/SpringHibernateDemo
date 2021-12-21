package edu.sda.sample.patterns.creational.factory;

public class MacBookAir extends MacBook {

    private String name;
    private String disc;
    private int memory;

    public MacBookAir(String name, String disc, int memory) {
        System.out.println("Konstruktor MacBook Air");
        this.name = name;
        this.disc = disc;
        this.memory = memory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDiscSize() {
        return disc;
    }

    @Override
    public int getMemory() {
        return memory;
    }
}
