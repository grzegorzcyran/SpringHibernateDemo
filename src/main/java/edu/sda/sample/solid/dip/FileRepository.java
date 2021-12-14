package edu.sda.sample.solid.dip;

public class FileRepository {

    public void saveTask(String filename) {
        System.out.println("Saving " + filename);
    }

    public void deleteTask(String filename) {
        System.out.println("Deleting" + filename);
    }
}
