package edu.sda.sample.solid.dip.fix;

public class FixedDIPTest {

    public static void main(String[] args) {

        /**
         * IOC czyli Inversion Of Control
         * czyli zasada odwrócenia zależności
         * chodzi o to żeby obiekt klasy nie inicjował sam swoich zależności
         * (czyli np klasa Task... nie robi new Repository()...)
         * tylko obiekt interfejsu Repository "dostaje", w naszym przypadku w konstruktorze
         */

        //Repository repository = new FileRepository();
        Repository repository = new DatabaseRepository();
        //przekazanie repository jako zależności do konstruktora klasy
        //TaskServiceByConstructor to właśnie wstrzyknięcie
        TaskServiceByConstructor service = new TaskServiceByConstructor(repository);

        //przekazanie przez setter
        TaskServiceBySetter setterService = new TaskServiceBySetter();
        setterService.setRepository(repository);

        //przekazywane przez pole
        //nie ma konstruktora, nie ma settera,
        //"wstrzyknięcie" załatwiane przez FRAMEWORK robiący IoC (Spring, Micronaut, Quarkus, ...)
        TaskServiceByField byField = new TaskServiceByField();
        byField.addTask("Coś");
    }
}
