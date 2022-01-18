package edu.sda.sample.patterns.structural.flyweight;

import java.util.Arrays;
import java.util.List;

public class FlyweightDemo {

    public static void main(String[] args) {

        FordMustang mustang1 = new FordMustang("Midnight Sky", "4.0", "Sony");
        FordMustang mustang2 = new FordMustang("Ruby Red", "4.5", "Denon");
        FordMustang mustang3 = new FordMustang("Midnight Sky", "3.5", "Denon");
        FordMustang mustang4 = new FordMustang("Black Panther", "3.2", "Sony");
        FordMustang mustang5 = new FordMustang("Midnight Sky", "4.0", "Denon");

        FordMustang mustang6 = new FordMustang("Ruby Red", "4.5", "Yamaha");

        System.out.println("======================");

        FordMustangBaseFactory.getFordMustangBaseSet()
                        .forEach(x -> System.out.println(x.getEngine() + " " + x.getColor()));

        System.out.println("======================");

        System.out.println(mustang1);

        System.out.println("======================");
        List<FordMustang> mustangs = Arrays.asList(mustang1, mustang2, mustang3, mustang4, mustang5, mustang6);
        mustangs.forEach(x -> System.out.println(x.printMustangData()));

    }
}
