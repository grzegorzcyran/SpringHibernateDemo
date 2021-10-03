package edu.sda.sample.model;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * DAO - Data Access Object
 * czyli
 * klasa / interfejs (klasy / interfejsy) umożliwiające dostęp
 * do danych - w naszym przypadku do Human i HumanDTO
 *
 *
 */

@AllArgsConstructor
public class HumanDAO {

    private List<Human> people;

    public List<Human> getAll() {
        return people;
    }

    public Human addNew(Human human) {
        people.add(human);
        return human;
    }

    public Human changeName(Human human, String newName) {
        people.stream() //stream() to odpowiednik for
                //filter ma nam znaleźć każdy element listy people
                //gdzie człowiek jest ten sam co w parametrze metody
                .filter(check -> check.equals(human)) //odpowiednik if
                .forEach(found -> found.setName(newName));

        // Iteracyjny odpowiednik tego co wyżej:
//        for (Human person : people) {
//            if(person.equals(human)) {
//                person.setName(newName);
//            }
        return human;
    }

}

