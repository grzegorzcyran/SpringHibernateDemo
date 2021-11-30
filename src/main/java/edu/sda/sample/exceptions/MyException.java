package edu.sda.sample.exceptions;

public class MyException extends IllegalArgumentException {

    public MyException() {
        super(); //ta linia jest niepotrzebna bo Java automatycznie wywoła
        //konstruktor bezparametrowy nadklasy
    }

    public MyException(String s) {
        super(s); //wywołanie konstruktora klasy IllegalArgumentException
        System.out.println("Wystąpił wyjątek MyException");
        //wywołanie konstruktora "nadklasy" MUSI być pierwszą linią konstruktora "podklasy"
    }
}
