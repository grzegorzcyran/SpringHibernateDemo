package edu.sda.sample.patterns.creational.factory;

public class MacBookPro extends MacBook {

    private String name;
    private String disc;
    private int memory;
    private int screenSize;

    public MacBookPro(String name, String disc, int memory) {
        System.out.println("Konstruktor MacBook Pro");
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

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
