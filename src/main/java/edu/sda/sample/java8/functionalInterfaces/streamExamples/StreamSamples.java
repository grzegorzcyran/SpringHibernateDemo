package edu.sda.sample.java8.functionalInterfaces.streamExamples;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Strumień - obiekt zawierający ciąg jednakowych obiektów
 * - do wykorzystania raz bo strumień jest PANTHA REI - nie ma powrotu do już przerobionego elementu strumienia
 * - można robić łączenia: strumień, z niego kolekcja i z niej kolejny strumień
 *
 * Operacje na strumieniach:
 * 1. Tworzenie strumieni:
 *  - metoda stream() - np. z kolekcji
 *  - metoda of() - z podanych elementów
 *  - Arrays.stream(Object[]) - tworzenie strumienia z elementów tabeli
 *  - ... powstaje więcej, np przy odczycie pliku, kolejne linie
 *
 * 2. Modyfikacja / albo nie - metody pośrednie
 *  - map - wykonanie (jakiegoś) przekształcenia
 *  - filter - sprawdzenie warunku
 *  - flatMap - spłaszczenie strumienia (szerzej przy przykładzie)
 *  - limit - ograniczająca ilość przetwarzanych elementów
 *  - distinct - wybierająca elementy niepowtarzalne
 *
 * 3. Metody kończące strumien:
 *  - toArray() - generująca tabelę z elementów strumienia
 *  - collect - zwraca "coś" - to może być kolekcja, może być 1 obiekt
 *  - reduce - zwraca 1 obiekt / wartość
 *  - count - zwraca ilość elementów wyjściowych strumienia
 *  - sum - zwraca sumę elementów
 *  - max - maksymalna wartość (wg jakiegoś kryterium)
 *  - findFirst - zwraca pierwszy wyjściowy element strumienia
 *  - findAny - zwraca dowolny wyjściowy element strumienia
 *  - forEach - nic nie zwraca, wykonuje operację na elementach strumienia
 *
 *  Operacje na strumieniu:
 *   - muszą zawierać metodę tworzącą strumień
 *   - mogą zawierać 1 lub więcej metod pośrednich (albo żadnej)
 *   - muszą zawierać jedną metodę kończącą
 */

public class StreamSamples {

    /**
     *
     * Jeśli tu zrobimy inną klasę to będzie to klasa wewnętrzna - do użycia we wszystkich metodach klasy StreamSamples
     */

    public static void main(String[] args) {

        //klasa lokalna - klasa wewnątrz metody
        //widoczna tylko w metodzie w której jest powołana
        class CarDTO {
            String fullName;
            int noOfSeats;
            public CarDTO( String fullName, int noOfSeats) {
                this.fullName = fullName;
                this.noOfSeats = noOfSeats;
            }
        }

        Car familyCar = new Car("Ford SMax", "1.8", 7);
        Car bigCar = new Car("Ford Ranger", "3.8", 4);
        Car smallCar = new Car("Ford Fiesta", "1.2", 5);
        Car sportCar = new Car("Ford Mustang", "4.5", 2);

        List<Car> carList = new ArrayList<>();
        carList.add(familyCar);
        carList.add(smallCar);
        carList.add(bigCar);
        carList.add(sportCar);

        //Strumień:
        //stream() tworzy strumień
        //tu nie mamy metody pośredniej
        //forEach kończy i wykonuje jakieś operacje
        carList.stream()
                .forEach(each -> System.out.println(each));

        System.out.println("\nSamochody z co najmniej 5 siedzeniami");
        //Wypiszemy samochody z liczbą siedzeń co najmniej 5
        for (Car car : carList) {
            if(car.getNoOfSeats() >= 5) {
                System.out.println(car.getName() + " " + car.getEngine() + " il.siedzeń:" + car.getNoOfSeats());
            }
        }

        System.out.println("\nA teraz strumienień to samo - sposób 1:");
        //to samo ale strumieniem
        carList.stream()
                .filter(each -> each.getNoOfSeats() >= 5)
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("\nA teraz strumienień to samo - sposób 2:");
        //to samo ale strumieniem i mapa
        carList.stream()
                .filter(each -> each.getNoOfSeats() >= 5)
                .map(each -> each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats())
                //.forEach(each -> System.out.println(each));
                //powyższe each -> sout... można zastąpić tzw. method reference
                //czyli wskazaniem metody która ma zostać wykonana dla przekazanego obiektu
                //zasada jest taka: obiekt na wejściu metody strumieniowej (u nas forEach)
                //jest bez przekształcania przekazywany do metody wskazanej (u nas println)
                .forEach(System.out::println);

        System.out.println("\nDwa pierwsze elementy:");
        carList.stream()
                .limit(2)
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("Kolejność ma znaczenie 1 :");
        carList.stream()
                .limit(2)
                .filter(each -> each.getNoOfSeats() > 4)
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("Lista samochodów przekształcona na listę CarDTO");
        List<CarDTO> dtoList = carList.stream()
                .map(each -> new CarDTO(each.getName() + " " + each.getEngine(), each.getNoOfSeats()))
                .collect(Collectors.toList());

        System.out.println("Lista samochodów przekształcana na set CarDTO");
        Set<CarDTO> dtoSet = carList.stream()
                .map(each -> new CarDTO(each.getName() + " " + each.getEngine(), each.getNoOfSeats()))
                .collect(Collectors.toSet());

        System.out.println("\nPrzekształcenie kolekcji w kolekcję i kolejny raz strumień i coś:");
        carList.stream()
                .map(each -> each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats())
                .collect(Collectors.toList()) //tu strumienia już nie ma bo zrobiliśmy collect() i mamy listę Stringów
                .stream() //a to już stream z uzyskanej wyżej listy Stringów
                .filter(x -> x.length() > 20)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\nFlatmapa");
    }
}
