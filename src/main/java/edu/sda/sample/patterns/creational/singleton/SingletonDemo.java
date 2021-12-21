package edu.sda.sample.patterns.creational.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        //EagerSingleton singleton2 = new EagerSingleton(); prywatny konstruktor, to nie przejdzie

        eagerSingleton.getMinimumSalary();
        System.out.println("");
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        lazySingleton1.setVariable("AAAAAAAAA");

        System.out.println("Odczytujemy lazy2:");
        System.out.println(lazySingleton2.getVariable());

    }
}
