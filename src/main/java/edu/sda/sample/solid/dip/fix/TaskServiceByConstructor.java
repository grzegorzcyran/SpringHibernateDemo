package edu.sda.sample.solid.dip.fix;

public class TaskServiceByConstructor {

    Integer version;
    String patchNumber;

    Repository repository;

    /**
     * Jeśli mamy klasę Car
     * To jego pola to mogą być:
     * Engine engine;
     * List<Seat> seats;
     * i Engine i List<Seats> mogą (powinny - z wyjątkiem kolekcji) być KLASAMI bo przechowują dane
     */

    /**
     * Wstrzykiwanie przez konstruktor
     * Czyli mamy obiekt "zależny" repository (zależność czyli pole wewnątrz klasy)
     * Ale nie inicjujemy go przez "new" w klasie TaskServiceByConstructor
     * Kolejna rzecz to rozdzielenie klas warstwą abstrakcji
     * Tutaj mamy INTERFEJS ale do konkretnego obiektu TaskServiceByConstructor
     * będziemy przekazywać konkretną implementację tego interfejsu
     *
     * Zależności staramy się przekazać jako interfejsy
     *
     */

    public TaskServiceByConstructor(Repository repository) {
        this.repository = repository;
    }

    public void addTask(String task) {
        repository.saveTask(task);
    }

    public void removeTask(String task) {
        repository.deleteTask(task);
    }
}
