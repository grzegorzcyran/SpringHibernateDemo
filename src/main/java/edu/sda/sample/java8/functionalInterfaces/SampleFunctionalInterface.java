package edu.sda.sample.java8.functionalInterfaces;

/**
 * Interfejs funkcyjny
 * Dokładnie jedna metoda abstrakcyjna
 * Mogą być inne metody ale:
 *  - albo domyślne
 *  - albo statyczne
 *  - albo prywatne
 */

@FunctionalInterface
public interface SampleFunctionalInterface {

    void sampleAbstractMethod();

    //jeśli dodamy kolejną metodę abstrakcyjną to anotacja będzie krzyczeć
    //void anotherMethod();

    default void defaultMethod() {
        System.out.println("Default way of solving problem");
    }

}
