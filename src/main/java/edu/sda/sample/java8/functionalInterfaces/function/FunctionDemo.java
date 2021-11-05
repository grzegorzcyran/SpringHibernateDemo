package edu.sda.sample.java8.functionalInterfaces.function;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Function - interfejs przekształcania
 * przyjmuje obiekt jako argument
 * robi przekształcenie
 * zwraca obiekt - ten który wszedł, albo inny
 *
 * Interfejs Function zakłada implementację metody "apply"
 */

public class FunctionDemo {

    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.8");
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car volvoCar = new Car("Volvo V50", "1.8");

        Function<Car, String> toPrint = (it) -> it.getName() + " " + it.getEngine();

        System.out.println("Drukujemy funkcją");
        System.out.println(toPrint.apply(familyCar));
        System.out.println(toPrint.apply(volvoCar));


        /**
         * Wszelkie interfejsy funkcyjne zezwalają na wieloliniowe implementacje metod abstrakcyjnych
         * czyli nie muszą to być jednolinijkowce, ale wtedy po każdej linii ma być średnik
         * i na końcu (dla Function, Supplier, Predicate) instrukcja return
         */

        Function<Car, Map<String, String>> parts = (it) -> {
            System.out.println("Robimy spis części i cech samochodu dla " + it.getName());
            Map<String, String> carParts = new HashMap<>();
            carParts.put("NAZWA", it.getName());
            carParts.put("SILNIK", it.getEngine());
            return carParts;
        };

        System.out.println("Wykorzystajmy stworzoną mapę");
        Map<String, String> sportCarParts = parts.apply(sportCar);
        for(Map.Entry entry :  sportCarParts.entrySet()) {
            System.out.println("Klucz: " + entry.getKey());
            System.out.println("Wartość: " + entry.getValue());
        }
    }

}
