package edu.sda.sample.solid.dip.fix;

public class TaskServiceBySetter {

    Repository repository;

    //konstruktor mamy domyślny, bezparametrowy

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void addTask(String task) {
        repository.saveTask(task);
    }

    public void removeTask(String task) {
        repository.deleteTask(task);
    }
}
