package edu.sda.sample.patterns.creational.factory;

public class FactoryTest {

    public static void main(String[] args) {
        //nie robimy (znowu) new MacBook

        MacBook mac1 = MacBookFactory.getMac("AIR", "Air", "256G", 8);
        MacBook mac2 = MacBookFactory.getMac("pro", "Pro", "256G", 16);
        MacBook mac3 = MacBookFactory.getMac("PRO", "Pro", "512G", 8);
        MacBook mac4 = MacBookFactory.getMac("pRo", "Pro", "1T", 32);

    }
}
