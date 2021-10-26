package edu.sda.sample.collections;

import edu.sda.sample.model.Human;

import java.util.HashMap;
import java.util.Map;

/**
 * Z mapami jest analogicznie jak z setami:
 * HashMap
 * LinkedHashMap
 * TreeMap
 * i to oznacza że w mapie gdzie mamy <Klucz, Wartość> elementy klucza są odpowiednio
 * HashSet, LinkedHashSet, TreeSet
 */

public class MapSamples {

    public static void main(String[] args) {

        Human human1 = new Human("Janek", "Kowalski");
        Human human2 = new Human("Marek", "Piskorz");
        Human human3 = new Human("Paweł", "Luzien");

        //Map<Key, Value>
        Map<String, Human> humanBySurname = new HashMap<>();
        humanBySurname.put(human1.getSurname(), human1);
        humanBySurname.put(human2.getSurname(), human2);
        humanBySurname.put(human3.getSurname(), human3);
        System.out.println("Wielkość mapy: " + humanBySurname.size());
        //Klucze (skoro to set) to są niepowtarzalne
        //ale pod różnymi kluczami możemy przechowywać to samo
        //np.:
        humanBySurname.put("Kowalsky", human1);
        System.out.println("Wielkość mapy: " + humanBySurname.size());
        humanBySurname.put("Kowalsky", new Human("Janina", "Kowalsky"));
        System.out.println("Wielkość mapy: " + humanBySurname.size());


        humanBySurname.put("Kowalskie", human1);
        System.out.println("Wielkość mapy: " + humanBySurname.size());

        printMap(humanBySurname);

    }

    public static void printMap(Map<String, Human> people) {

        System.out.println("\nChodzenie po kluczach mapy");
        for(String readKey : people.keySet()) {
            System.out.println(readKey); //drukujemy klucz
            System.out.println(people.get(readKey)); //drukujemy obiekt dostępny pod kluczem

        }

        System.out.println("\n Chodzenie po wartościach");
        for(Human human : people.values()) {
            System.out.println(human);
        }

        System.out.println("\n Chodzenie po wpisach");
        for(Map.Entry entry: people.entrySet()) {
            System.out.println("Klucz:" + entry.getKey());
            System.out.println("Wartość:" + entry.getValue());
        }
    }

}
