package edu.sda.sample.patterns.behavioral.command;

public class CommandQueueDemo {

    public static void main(String[] args) {
        MyFile myFile = new MyFile("sample.txt");
        FileOperationSequenceExecutor executor = new FileOperationSequenceExecutor();

        executor.add(new CreateFileOperation(myFile), "Zawartosc poczatkowa");
        executor.add(new UpdateFileOperation(myFile), "Zawartosc dodatkowa");

        System.out.println("\nPlik przed wykonaniem kolejki \n");
        System.out.println(myFile.getContent());
        executor.execute();
        System.out.println("\nPlik po wykonaniu kolejki \n");
        System.out.println(myFile.getContent());
        System.out.println("=================================");
        executor.add(new UpdateFileOperation(myFile), "Jeszcze kolejna zawartosc");
        executor.execute();
        System.out.println(myFile.getContent());
        System.out.println("=================================");
        executor.add(new CreateFileOperation(myFile), "piszemy od zera");
        executor.execute();
        System.out.println(myFile.getContent());

        System.out.println("=================================");
        System.out.println("\nHistoria operacji\n");
        executor.getFileOperationHistory()
                .forEach(System.out::println);
    }
}
