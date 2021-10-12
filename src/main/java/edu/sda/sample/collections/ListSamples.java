package edu.sda.sample.collections;

import edu.sda.sample.model.Human;

import java.util.*;

public class ListSamples {

    /**
     * Listy
     *
     * List - interfejs czyli nie można zrobić obiektu bezpośrednio
     * Pozwala na przechowywanie duplikatów
     *
     * ArrayList - lista na podstawie tablicy czyli
     *  - w pamięci przechowywana w jednym ciągu
     *  - odczytywanie jest bardzo szybkie (O(1) - ten sam czas niezależnie od tego którą pozycję odczytujemy)
     *  - zapisywanie: na końcu struktury szybkie, w dowolnym innym miejscu wolne,
     *  może też być wolne jeśli wyczerpie się miejsce i trzeba przenieść całość
     *
     * LinkedList - łączenie za pomocą wskaźników poprzedni - następny
     *  - w pamięci przechowywana w sposób losowy
     *  - odczytywanie trwa bo trzeba przejść od pierwszego do żądanego elementu
     *  - zapisywanie na dowolne miejsce jest tak samo szybkie
     *
     */
    public static void main(String[] args) {
        Human human1 = new Human("Janek", "Kowalski");
        Human human2 = new Human("Marek", "Piskorz");
        Human human3 = new Human("Paweł", "Luzien");

        List<Human> people = new ArrayList<>();
        people.add(human1);
        people.add(human2);
        people.add(human3);
        /**
         * Jeśli od tego momentu działamy już tylko na liście
         * to GC może próbować usunąć obiekty human1, human2, human3
         * bo już z nich nie korzystamy
         */

        List<Human> linkedPeople = new LinkedList<>();
        linkedPeople.addAll(people); // dodaliśmy wszystkie elementy z jednej listy do drugiej

        //Po listach można iterować - przechodzić po kolei po elementach -
        //za pomocą indeksu
        System.out.println("Lecimy po indeksach:");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
        System.out.println("\n");

        //Lecimy po kolejnych elementach listy
        System.out.println("Po elementach");
        for (Human person : people) {
            System.out.println(person);
        }
        System.out.println("\n");

        linkedPeople.remove(2); // usuwanie spod indeksu
        linkedPeople.remove(human1); //usuwanie wskazanego obiektu (jeśli istnieje)
        //jeśli istnieje więcej niż jeden to usunięty zostanie pierwszy

        linkedPeople.add(human1);
        linkedPeople.add(human2);
        linkedPeople.add(human1);
        linkedPeople.add(human2);
        linkedPeople.add(human3);
        linkedPeople.add(human2);
        System.out.println("Wypisujemy z wszystkimi dublami");
        for (Human linkedPerson : linkedPeople) {
            System.out.println(linkedPerson);
        }
        System.out.println("\n");
    }

    /**
     * Garbage Collector i pamięć
     * 1 podział:
     *  - na obiekty - wspólna dla wątków
     *  - na zmienne nieobiektowe - każdy wątek ma swoją
     *
     * 2 podział:
     *  - String Pool - pamięć na wszelkie obiekty klasy String
     *  - pamięć na obiekty nie-String
     *    > old Gen, Eden, itd - będzie w artykule
     *
     *  GC - zajmuje się czyszczeniem pamięci przez niszczenie niepotrzebnych obiektów
     *  ALE nie działa na String Poolu
     *
     */

}


