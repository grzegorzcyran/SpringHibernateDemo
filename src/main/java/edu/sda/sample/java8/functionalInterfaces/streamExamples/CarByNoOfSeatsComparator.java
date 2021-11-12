package edu.sda.sample.java8.functionalInterfaces.streamExamples;

import edu.sda.sample.java8.functionalInterfaces.Car;

import java.util.Comparator;

public class CarByNoOfSeatsComparator implements Comparator<Car> {

    //compare zwraca int - jak mniej od 0 to pierwszy obiekt jest "najpierw", jeśli więcej niż 0 to drugi "najpierw"
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getNoOfSeats() - car2.getNoOfSeats();
    }
}
