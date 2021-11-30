package edu.sda.sample.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TryCatchSample {

    public void sleepThread(long millis) {

        /**
         * Jeśli to co mamy w bloku try zgłosi wyjątek, to jest on łapany przez catch
         *
         * Wyjątki:
         *  - checked - sprawdzane - jeśli użyjemy metody która może zwrócić ten wyjątek to MUSIMY go obsłużyć
         *  - unchecked - niesprawdzane - może się zdarzyć ale nie musimy go obsługiwać
         */
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Błąd w sleepThread");
            e.printStackTrace();
        }
    }

    public void sleepAndReadFile(long millis, String filename) {

        /**
         * Jeśli kod może rzucić kilka różnych wyjątków to możemy je łapać w osobnych klauzulach catch
         */
        try {
            Thread.sleep(millis);
            new FileReader(filename);
        } catch (InterruptedException e) {
            System.out.println("Coś przerwało");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma pliku");
            e.printStackTrace();
        }
    }

    public void sleepAndReadFileMulticatch(long millis, String filename) {

        try {
            Thread.sleep(millis);
            new FileReader(filename);
        } catch (FileNotFoundException | InterruptedException e) {
            /**
             * Od Javy 1.7 możliwe jest łapanie kilku różnych wyjątków 1 blokiem catch
             * Tyle że wtedy "skazujemy się" na taką samą obsługę obu wyjątków
             */
            System.out.println("Coś poleciało, albo plik, albo interrupt");
            e.printStackTrace();
        }
    }

    public void hierarchyExceptions(long millis, String filename) {

        try {
            Thread.sleep(millis);
            new FileReader(filename);
            //.. jeszcze jakiś kod - jeśli będzie inny wyjątek to poleci do Exception
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Bardziej szczegółowe wyjątki");
        } catch (Exception ex) {
            System.out.println("Bardziej ogólny wyjątek");
        }

    }

    //Rzucenie wyjątku niesprawdzanego
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        try {
            System.out.println("Drukujemy listę iterując po elementach");
            for (int i = 0; i < 10; i++) {
                System.out.println(list.get(i));
            }

        } catch (IndexOutOfBoundsException ex) {
            //łapiemy wyjątek unchecked - niesprawdzany
            System.out.println("Wyjątek w bieganiu po liście");
        }
        System.out.println("Po try/catch");


        System.out.println("Drukujemy listę iterując po elementach");
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
        //poniższe nie będzie wyświetlone bo przy iteracji w pętli wystąpi wyjątek i przerwie działanie
        System.out.println("Po pętli");
    }
}
