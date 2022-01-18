package edu.sda.sample.patterns.structural.flyweight;

import java.util.HashSet;
import java.util.Set;

public class FordMustangBaseFactory {

    private static Set<FordMustangBase> fordMustangBaseSet = new HashSet<>();

    public static FordMustangBase getMustangBase(String color, String engine) {
        FordMustangBase fordMustangBase;
        System.out.println(FordMustangBaseFactory.class + " getMustangBase");

        if(fordMustangBaseSet.size() > 0) {
            System.out.println("Base set not empty");
            //w istniejących zestawach poszukamy zamówione kombinacji "kolor, silnik"
            fordMustangBase = fordMustangBaseSet.stream()
                    .filter(f -> color.equals(f.getColor()) && engine.equals(f.getEngine()))
                    .peek(f -> System.out.println("Eureka, jest taki: " + f.getEngine() + " " + f.getColor()))
                    //findAny - jeśli znajdziemy to zwracamy do fordMustangBase i wychodzimy ze streama
                    .findAny()
                    //jak nie znaleźliśmy to w orElseGet utworzymy nową kombinację
                    .orElseGet(() -> getNewFordMustangBase(color, engine));
        } else {
            System.out.println("Base set empty, adding first element");
            fordMustangBase = getNewFordMustangBase(color, engine);
        }
        fordMustangBaseSet.add(fordMustangBase);
        return fordMustangBase;
    }

    private static FordMustangBase getNewFordMustangBase(String color, String engine) {
        return new FordMustangBase(color, engine);
    }

    public static Set<FordMustangBase> getFordMustangBaseSet() {
        return fordMustangBaseSet;
    }
}
