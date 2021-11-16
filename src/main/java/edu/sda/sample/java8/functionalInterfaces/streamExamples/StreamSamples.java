package edu.sda.sample.java8.functionalInterfaces.streamExamples;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 *  - peek - zasadniczo podobnie jak forEach ale w trakcie działania streama
 *  - sorted - umożliwiająca sortowanie elementów (zakłada że klasa implementuje Comparable, albo że wykorzystamy zewnętrzny komparator)
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

            public String getFullName() {
                return fullName;
            }
        }

        Car familyCar = new Car("Ford SMax", "1.8", 7);
        Car bigCar = new Car("Ford Ranger", "3.8", 4);
        Car smallCar = new Car("Ford Fiesta", "1.2", 5);
        Car sportCar = new Car("Ford Mustang", "4.5", 2);

        List<Car> carList = new ArrayList<>();
        carList.add(familyCar);
        carList.add(bigCar);
        carList.add(smallCar);
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

        System.out.println("\nKolejność ma znaczenie - zależy czy najpierw mamy limit czy filter to wynik będzie albo 1 albo 2 elementowy :");
        carList.stream()
                .limit(2)
                .filter(each -> each.getNoOfSeats() > 4)
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("\nLista samochodów przekształcona na listę CarDTO");
        List<CarDTO> dtoList = carList.stream()
                .map(each -> new CarDTO(each.getName() + " " + each.getEngine(), each.getNoOfSeats()))
                .collect(Collectors.toList());

        System.out.println("\nLista samochodów przekształcana na set CarDTO");
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
        List<CarDTO> allCarDtos = Stream.of(dtoList, dtoSet)
                .flatMap(it -> it.stream())
                .peek(it -> System.out.println("Wyświetlamy w trakcie działania streama: " + it.getFullName()))
                .collect(Collectors.toList());

        System.out.println("Wielkość kolekcji po złączeniu: " + allCarDtos.size());

        System.out.println("\nSortowanie wewnętrznym komparatorem:");
        carList.stream()
                .sorted()
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("\nSortowanie po liczbie siedzeń");
        carList.stream()
                .sorted(new CarByNoOfSeatsComparator())
                .forEach(each -> System.out.println(each.getName() + " " + each.getEngine() + " il.siedzeń:" + each.getNoOfSeats()));

        System.out.println("\nIlość siedzeń razem");
        int seatsTotal = carList.stream()
                .map(Car::getNoOfSeats)
                /**
                 * reduce - należy podać sposób w jaki z n elementów strumienia zrobić 1
                 *
                 * W naszym przypadku ilość siedzeń: zaczynamy od wartości początkowej : 0 (identity)
                 * current określa aktualną wartość do zwrócenia
                 * next określa wartość "przychodzącą z kolejnego elementu strumienia
                 *
                 * czyli
                 * zaczynamy od 0
                 * to aktualna 0, przychodząca 2
                 * przy kolejnym elemencie mamy już
                 * zaczynamy od 2, aktualna to 2, przychodząca to 4, itd
                 */
                .reduce(0, (current, next) -> current + next);
        System.out.println("Ilość siedzeń razem: " + seatsTotal);

        System.out.println("\nŁączenie nazw samochodów");
        System.out.println("1. Ordynarne");
        String uglyConcat = carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining());
        System.out.println("Ordynarny wynik: " + uglyConcat);

        System.out.println("\n2. Z przedzielaniem");
        String niceConcat = carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Z przedzelaniem wynik: " + niceConcat);

        System.out.println("\n3. Z przedzielaniem i początkiem i końcem");
        String withBracketsConcat = carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println("Z przedzelaniem i początkiem i końcem wynik: " + withBracketsConcat);

        Map<Integer, Car> carsBySeats = carList.stream()
                /**
                 * Map potrzebuje K, V, więc przy toMop mówimy co ma być czym
                 * w naszym przypadku pod klucz podstawiamy liczbę siedzeń, pod wartość podstawiamy aktualnie obrabiany obiekt Car
                 */
                //.collect(Collectors.toMap(x -> x.getNoOfSeats(), x -> x));
                .collect(Collectors.toMap(Car::getNoOfSeats, x -> x));

        System.out.println(carsBySeats.size());

        Car familyCar2 = new Car("Ford Cmax", "1.8", 7);
        Car bigCar2 = new Car("Ford Transit", "3.8", 3);
        Car smallCar2 = new Car("Ford Ka", "1.2", 4);

        carList.add(familyCar2);
        carList.add(bigCar2);
        carList.add(smallCar2);

        Map<String, List<Car>> carsByEngineGrouped = carList.stream()
                /**
                 *  Mamy mapę gdzie kluczem jest wielkość silnika i jako wartość będzie lista
                 *  wszystkich samochodów o danej wielkości silnika, stąd groupingBy i potem toList
                 */
                .collect(Collectors.groupingBy(Car::getEngine, Collectors.toList()));

        System.out.println("\nSamochody zgrupowane po wielkości silnika: " + carsByEngineGrouped.size());

        System.out.println("\nNajwiększa ilość siedzeń");
        Optional<Integer> possibleMaxSeats = carList.stream()
                .map(Car::getNoOfSeats)
                .max(Integer::compareTo);

        if(possibleMaxSeats.isPresent()) {
            System.out.println("Max ilość siedzeń: " + possibleMaxSeats.get());
        }

        //ifPresent działa tak, że jeśli w Optionalu coś jest to
        //właśnie ta zawartość zostanie użyta bezpośrednio, nie trzeba robić metody .get()
        possibleMaxSeats.ifPresent(it -> System.out.println("Max po nowemu:" + it));

    }
}
