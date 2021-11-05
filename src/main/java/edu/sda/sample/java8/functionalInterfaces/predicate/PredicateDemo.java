package edu.sda.sample.java8.functionalInterfaces.predicate;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.function.Predicate;

/**
 * Predicate - interfejs który służy do testowania (sprawdzania) warunków
 * Zakłada że nadpiszemy metodę "test"
 *
 * Przyjmuje obiekt, zwraca boolean
 */

public class PredicateDemo {

    public static void main(String[] args) {

        Car familyCar = new Car("Ford SMax", "1.8");
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car volvoCar = new Car("Volvo V50", "1.8");

        //it oznacza "cokolwiek co wpadło jako argument", w naszym przypadku to będzie Car
        // (it) -> costamcostam to skrócona postać nadpisanej metody test
        //system zakłada że zapis () -> {} (czyli lambda) to nadpisanie tej jedynej
        //w interfejsie funkcyjnym metody abstrakcyjnej
        Predicate<Car> isSmallEngine = (it) -> it.getEngine().compareTo("2.0") < 0;
        Predicate<Car> isVolvo = (it) -> it.getName().startsWith("Volvo");

        //to poniżej to odpowiednik tego skróconego zapisu powyżej
        Predicate<Car> isSportCar = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getEngine().compareTo("3.0") > 0;
            }
        };

        System.out.println("Sprawdzamy czy mały silnik");
        printCar(familyCar, isSmallEngine);
        printCar(sportCar, isSmallEngine);
        printCar(volvoCar, isSmallEngine);
        System.out.println("Sprawdzamy czy Volvo");
        printCar(familyCar, isVolvo);
        printCar(volvoCar, isVolvo);
        System.out.println("Sprawdzamy czy sportowy - czyli tą 'dużą', jawnie nadpisaną metodę");
        printCar(familyCar, isSportCar);
        printCar(sportCar, isSportCar);


    }

    public static void printCar(Car car, Predicate<Car> predicate) {
        if(predicate.test(car)) {
            System.out.println(car.getName() + " " + car.getEngine());
        }
    }
}
