package edu.sda.sample.solid.dip.fix;

public class DatabaseRepository implements Repository{


    @Override
    public void saveTask(String task) {
        System.out.println("Saving do DB " + task);
    }

    @Override
    public void deleteTask(String task) {
        System.out.println("Deleting to DB " + task);

    }
}
