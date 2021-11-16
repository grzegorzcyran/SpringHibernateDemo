package edu.sda.sample.java8.functionalInterfaces.optional;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Optional to "pojemnik"
 * w środku może być obiekt, ale może też go nie być
 * Optional sugeruje sprawdzenie zawartości przed jej użyciem
 */

public class OptionalDemo {

    public static void main(String[] args) {

        Car familyCar = new Car("Ford SMax", "1.8");
        Car sportCar = new Car("Ford Mustang", "4.5");
        Car nullCar = null;

        //kontener zrobiony metodą "of" zakłada że obiekt "wkładany" jest nienullofy
        Optional<Car> existingCar = Optional.of(familyCar);

        //jeśli mamy obiekt co do którego nie ma pewności czy jest nullowy to
        Optional<Car> whoKnowsCar = Optional.ofNullable(nullCar);
        //jeśli do metody "of" przekażemy obiekt nullowy to dostaniemy wyjątek NPE
        //whoKnowsCar = Optional.of(nullCar);

        //Optional jest po to żeby nie było konieczności robienia:
        if(nullCar != null) {
            System.out.println("Obiekt nie jest nullem");
        }

        //teraz robimy to tak:
        //java 11
        if(whoKnowsCar.isEmpty()) {
            System.out.println("obiekt jest nullem");
        }
        //java 8
        if(whoKnowsCar.isPresent()) {
            System.out.println("obiekt nie jest nullem");
        }

        List<Car> cars = new ArrayList<>();
        cars.add(sportCar);
        cars.add(familyCar);

        System.out.println("\nSzukamy dowolnego forda, z metodą orElse");
        Car findAnyFord = cars.stream()
                .filter(it -> it.getName().contains("Ford"))
                .findFirst()
                .orElse(getDefaultCar());
        System.out.println("Znaleziono : " + findAnyFord.getName());

        System.out.println("\nSzukamy dowolnego forda, z metodą orElseGet");
        Car findOtherFord = cars.stream()
                .filter(it -> it.getName().contains("Ford"))
                .findFirst()
                .orElseGet(() -> getDefaultCar());
        System.out.println("Znaleziono : " + findOtherFord.getName());

    }

    private static Car getDefaultCar() {
        System.out.println("Dodajemy samochód zastępczy");

        return new Car("Fiat Brava", "1.2");
    }
}
