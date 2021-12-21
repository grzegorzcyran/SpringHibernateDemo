package edu.sda.sample.patterns.creational.singleton;

//EAGER oznacza "od razu", w tym przypadku od razu tworzymy obiekt
//przy kompilacji klasy (przy uruchamianiu programu)

public class EagerSingleton {
    private final int YEAR2000 = 2000;
    private final int MINIMUM_SALARY = 2500;

    //INSTANCE - popularna uogólniona nazwa obiektu danej klasy
    //w przypadku zwłaszcza gdy mamy jeden obiekt
    //tu INSTANCE to obiekt naszej klasy EagerSingleton
    private static final EagerSingleton INSTANCE = new EagerSingleton();


    //prywatny konstruktor - nie dostaniemy się do niego z zewnątrz więc nie
    //utworzymy kolejnych obiektów naszej klasy
    private EagerSingleton() {
        System.out.println("Konstruktor EagerSingleton");
    }

    //metoda zwracająca nasz obiekt - ten który jest utworzony wyżej
    public static EagerSingleton getInstance() {
        System.out.println("EagerSingleton.getInstance");
        return INSTANCE;
    }

    public int getYear2000() {
        return YEAR2000;
    }

    public int getMinimumSalary() {
        return MINIMUM_SALARY;
    }

}
