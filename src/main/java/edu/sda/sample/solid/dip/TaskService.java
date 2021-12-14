package edu.sda.sample.solid.dip;

public class TaskService {

    private FileRepository fileRepository = new FileRepository();

    public void addTask(String task) {
        fileRepository.saveTask(task);
    }

    public void removeTask(String task) {
        fileRepository.deleteTask(task);
    }

}
