package edu.sda.sample.solid.dip;

public class NoDIPDemo {
    public static void main(String[] args) {

        /**
         * TaskService wykorzystuje obiekt klasy FileRepository
         * Ten obient NIE JEST WSTRZYKIWANY
         * Jest on inicjowany przez "new" wewnątrz klasy TaskService
         *
         * DIP polega na tym że nie inicjujemy jednych obiektów
         * wewnątrz innych, tylko są one "wstrzykiwane" czyli:
         *  - przekazywane przez konstruktor
         *  - przekazywane przez setter
         *  - przekazywane przez pole
         */


        TaskService taskService = new TaskService();

        taskService.addTask("SampleFile.txt");
        taskService.removeTask("SampleFile.txt");
    }
}
