package edu.sda.sample.model;

import java.util.Comparator;

/**
 * Implementacji interfejsu Comparator może być kilka, dostosowanych do różnych kryteriów
 */

public class HumanByAgeAndName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        //w pierwszym kroku sprawdzimy czy obiekty mają różny wiek i jak tak to uszeregujemy
        if(o1.getAge() - o2.getAge() != 0) {
            return o1.getAge() - o2.getAge();
        }
        //jeśli doszliśmy tu to znaczy że obiekty mają ten sam wiek
        //i teraz porównujemy imiona alfabetycznie
        return o1.getName().compareTo(o2.getName());
    }
}
