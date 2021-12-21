package edu.sda.sample.patterns.creational.singleton;

//Lazy czyli "nie od razu, raczej przy pierwszym wywołaniu"

public class LazySingleton {

    //obiekt tak jak w Eager jest wewnątrz klasy
    private static LazySingleton INSTANCE;

    private String variable;

    //konstruktor tak jak w Eager jest prywatny
    private LazySingleton() {
        System.out.println("Konstruktor LazySingleton");
    }

    //metoda sprawdza czy obiekt został zainicjowany
    //jeśli nie to go inicjuje i zwraca
    //jeśli już był zainicjowany to tylko zwraca
    public static LazySingleton getInstance() {
        System.out.println("LazySingleton.getInstance");
        if(INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
