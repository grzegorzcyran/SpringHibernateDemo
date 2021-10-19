package edu.sda.sample.model;

import java.util.Comparator;

/**
 * Implementacji interfejsu Comparator może być kilka, dostosowanych do różnych kryteriów
 */

public class HumanBySurnameAndNoOfChildren implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {

        //compareTo zwraca int -
        // - mniej niż 0 - jeśli pierwszy obiekt ma być "pierwszy"
        // - jeśli obiekty są równe ( w naszym przypadku jeśli jest to samo imię)
        // - więcej niż 0 - jeśli pierwszy obiekt ma być "drugi"
        if(o1.getName().compareTo(o2.getName()) != 0) {

            return o1.getName().compareTo(o2.getName());
        }


        return o1.getNoOfChildren() - o2.getNoOfChildren();
    }
}
