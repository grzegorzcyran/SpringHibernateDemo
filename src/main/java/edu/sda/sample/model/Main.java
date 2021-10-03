package edu.sda.sample.model;

public class Main {

    public static void main(String[] args) {

        Human human1 = new Human("Janek", "Kowalski");
        Human human2 = new Human("Jan", "Kowalski");
        Human human3 = new Human("Jaś", "Kowalski", 12, "AAA 123", 0, "M");

        //poniższe domyślnie woła toString na obiekcie bo println przyjmuje String
        System.out.println(human1);
    }
}
