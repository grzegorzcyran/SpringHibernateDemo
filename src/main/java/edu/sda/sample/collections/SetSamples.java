package edu.sda.sample.collections;

import edu.sda.sample.model.Human;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Jeśli chodzi o anotacje Lombokowe ( i w sumie wszelkie inne) to RTFM
 *
 */

@EqualsAndHashCode
public class SetSamples {

    public static void main(String[] args) {

        Human human1 = new Human("Janek", "Kowalski");
        Human human2 = new Human("Marek", "Piskorz");
        Human human3 = new Human("Paweł", "Luzien");

        /**
         * Set - zbiór niepowtarzalnych obiektów
         *
         * Podstawowa implementacja to HashSet - wykorzystuje metodę hashCode() do rozróżniania obiektów
         * i decydowania czy nowo wstawiany obiekt już jest w kolekcji czy jeszcze nie. W HashSet dane są nieuporządkowane,
         *  nie mają określonej kolejności, decyduje "hashCode" i nie da się z niego wprost określić kolejności obiektów
         *
         *
         */
        Set<Human> people = new HashSet<>();
        people.add(human1);
        people.add(human2);
        people.add(human3);

        people.forEach(System.out::println);

        //Dodanie tych samych elementów nie zwiększa seta
        System.out.println("Dodajemy drugi raz to samo");
        people.add(human1);
        people.add(human2);
        people.add(human3);

        people.forEach(System.out::println);

        //LinkedHashSet - będzie pamiętał kolejność wstawiania obiektów do seta
        Set<Human> linkedSet = new LinkedHashSet<>();
        linkedSet.add(human3);
        linkedSet.add(human1);
        linkedSet.add(human2);
        System.out.println("\nTeraz mamy LinkedHashSet, zachowujemy kolejność wstawiania rekordów");
        linkedSet.forEach(System.out::println);
        linkedSet.add(human3);
        linkedSet.add(human1);
        linkedSet.add(human2);
        System.out.println("\nNadal w LinkedHashSet nie możemy mieć duplikatów");
        linkedSet.forEach(System.out::println);

        //TreeSet - będzie trzymał kolejność określoną przez komparator
        //Żeby zrobić TreeSet to klasa Human musi mieć implementację interfejsu Comparable
        //bo na jego podstawie jest układanie obiektów w kolekcji
        Set<Human> orderedSet = new TreeSet<>();
        orderedSet.add(human3);
        orderedSet.add(human1);
        orderedSet.add(human2);
        System.out.println("\nTeraz mamy TreeSet, zachowujemy kolejność określoną przez porównanie obiektów");
        orderedSet.forEach(System.out::println);
        System.out.println("Wielkość seta:" + orderedSet.size());


    }
}
