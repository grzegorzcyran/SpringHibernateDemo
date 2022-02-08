package edu.sda.sample.patterns.behavioral.command;

public class CommandDemo {

    public static void main(String[] args) {
        MyFile myFile = new MyFile("sample.txt");
        FileOperationExecutor executor = new FileOperationExecutor();

        executor.execute(new CreateFileOperation(myFile), "Zawartosc poczatkowa");
        executor.execute(new UpdateFileOperation(myFile), "Zawartosc dodatkowa");

        System.out.println(myFile.getContent());
        System.out.println("=================================");
        executor.execute(new UpdateFileOperation(myFile), "Jeszcze kolejna zawartosc");

        System.out.println(myFile.getContent());
        System.out.println("=================================");
        executor.execute(new CreateFileOperation(myFile), "piszemy od zera");
        System.out.println(myFile.getContent());

        System.out.println("=================================");
        System.out.println("\nHistoria operacji\n");
        executor.getFileOperationHistory()
                .forEach(System.out::println);
    }
}
