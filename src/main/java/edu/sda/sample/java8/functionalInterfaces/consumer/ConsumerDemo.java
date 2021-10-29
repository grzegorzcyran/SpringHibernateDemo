package edu.sda.sample.java8.functionalInterfaces.consumer;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.sql.SQLOutput;
import java.util.function.Consumer;

/**
 * Interfejs funkcyjny Consumer
 *  - przyjmuje obiekt
 *  - nic nie zwraca
 *  - może na tym obiekcie (albo wogóle) wykonać jakieś działanie
 */

public class ConsumerDemo {

    public static void main(String[] args) {

        Car familyCar = new Car("Ford SMax", "2.5");
        Car sportCar = new Car("Ford Mustang", "4.5");

        //poniższe oznacza: interfejs Consumer przyjmujący jako parametr obiekt klasy Car
        Consumer<Car> printCarMark = (xxx) -> {
            System.out.println("Printing car's mark for : " + xxx.getName());
            System.out.println(xxx.getName().substring(0, xxx.getName().indexOf(" ")));
        };

        //Interfejs consumer wywoła metodę accept() - to jest jego jedyna abstrakcyjna metoda
        printCarMark.accept(familyCar);
        printCarMark.accept(sportCar);

        //poniżej klasa anonimowa jako implementacja interfejsu Consumer
        Consumer<Car> printEngineParams = new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                System.out.println("Old Style interface call");
                System.out.println(car.getEngine());
            }
        };

        System.out.println("A teraz w starym stylu");
        printEngineParams.accept(familyCar);
    }
}
