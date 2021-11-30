package edu.sda.sample.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryFinallySample {

    public void readFile(String filename) throws IOException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            /**
             * Blok finally może wystąpić po
             * try / catch -> będziemy mieć try / catch / finally
             * albo po
             * try -> będziemy mieć try / finally
             *
             * Blok finally jest po to że jeśli w try otworzyliśmy jakieś zasoby
             * czyli połączenie z plikiem, siecią, bazą danych
             * to takie połączenie należy zamknąć
             *
             * Blok finally wykona się ZAWSZE, niezależnie czy try skończyło się poprawnie
             * czy rzuciło wyjątek i poszliśmy do catch
             */
            reader.close();
        }
    }

    public void readFileWithResources(String filename) {

        //Od Javy 1.7
        //try - with - resources
        //czyli try(zasoby które w bloku try "otwieramy")
        //działamy
        //blok try - with - resources AUTOMATYCZNIE zamknie nam wszystkie zasoby otwarte
        //niezależnie czy poszło do catch czy nie
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.read();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Przy try - with - resources nie ma potrzeby robić finally");
            System.out.println("Ale możemy, jeśli chcemy tam zrobić coś innego niż zamykanie zasobów");
        }
    }

}
