package edu.sda.sample.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
//@ToString
public class Human {
    private String name;
    private String surname;
    private int age;
    private String identity;
    private int noOfChildren;
    private String gender;

    //Hibernate wymaga konstruktora bezparametrowego
    //jak jest anotacja @NoArgsConstructor to nie jest wymagany
//    public Human() {
//    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, int age, String identity, int noOfChildren, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identity = identity;
        this.noOfChildren = noOfChildren;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name: " + name + " surname " + surname;
    }

    @Override
    public boolean equals(Object o) {
        //sprawdzenie referencji czyli miejsca w pamięci - jak obiekty zajmują to samo
        //miejsce w pamięci to wiadomo że to ten sam obiekt
        if (this == o) return true;

        //jeśli to co przyszło jest null albo jest innej klasy to wiadomo że to nie ten sam obiekt
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;
        //porównujemy pole po polu te dane wg których chcemy identyfikować niepowtarzalność obiektu
        return Objects.equals(name, human.name)
                && Objects.equals(surname, human.surname)
                && Objects.equals(identity, human.identity)
                && Objects.equals(gender, human.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, identity, gender);
    }
}
