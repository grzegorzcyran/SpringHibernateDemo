package edu.sda.sample.java8.functionalInterfaces.supplier;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.function.Supplier;

/**
 * Supplier - interfejs funkcyjny
 *  - nie przyjmuje żadngo parametru
 *  - zwraca obiekt
 */

public class SupplierDemo {

    public static void main(String[] args) {
        Car car = new Car("Ford SMax", "1.8");
        Supplier<Car> sportCar = () -> new Car("Ferrari", "5.2");
        Supplier<Car> vanCar = () -> new Car("VW Transporter", "3.2");

        System.out.println("Po deklaracjach, przed wykorzystaniem");
        //Supplier wymaga implementacji metody get()
        Car resultCar = vanCar.get();
//        System.out.println(vanCar.get().getName() + vanCar.get().getEngine());
        System.out.println(resultCar.getName() + resultCar.getEngine());

        System.out.println("Wołamy metodę zewnętrzną");
        System.out.println(carInfo(sportCar));
        System.out.println(carInfo(vanCar));
    }

    public static String carInfo(Supplier<Car> someSupplier) {
        Car passedCar = someSupplier.get();
        System.out.println("Metoda carInfo");

        return new StringBuilder(passedCar.getName())
                .append(" ")
                .append(passedCar.getEngine())
                .toString();

        //StringBuffer - wolniejszy bo zapewnia bezpieczeństwo w aplikacji wielowątkowej
    }
}
