package edu.sda.sample.solid.dip.fix;

public class TaskServiceByField {

    //@Autowired
    //Anotacja Springa pozwalająca na ominięcie konstruktora i settera i "wstrzyknięcie"
    //zależności bezpośrednio do pola
    Repository repository;

    //konstruktor domyślny

    public void addTask(String task) {
        repository.saveTask(task);
    }

    public void removeTask(String task) {
        repository.deleteTask(task);
    }
}
