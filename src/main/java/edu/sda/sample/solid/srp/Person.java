package edu.sda.sample.solid.srp;

/**
 * Klasa do:
 *  - przechowywania danych osoby
 *  - sprawdzanie czy osoba może mieć prawo jazdy
 *
 * SRP zakłada 1 odpowiedzialność (albo jeden powód zmiany). A tu możemy mieć dwa:
 *  - może nam dojść kolejne pole (id, płeć, ilość dzieci, ...)
 *
 *  - może się zmienić logika wg jakiej osoba może mieć prawko (bo np wdrażamy nasz soft w USA)
 *
 *
 */

public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    //gettery

    public boolean canGetDrivingLicense() {
        return age >= 18;
    }
}
