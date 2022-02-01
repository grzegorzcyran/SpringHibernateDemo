package edu.sda.sample.patterns.structural.bridge;

//==================
// warstwa abstrakcyjna
//uzgodniona między zespołami
//==================
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    public Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract public void manufacture();
}

interface Workshop {
    void performWork();
}

//==================
// zespół 1 robi klasy implementujące interfejs
// i nic więcej
//==================
class Produce implements Workshop {
    @Override
    public void performWork() {
        System.out.println("Item produced.");
    }
}

class Assemble implements Workshop {
    @Override
    public void performWork() {
        System.out.println(" And \n Assembled.");
    }
}


//==================
// zespół 2 robi klasy rozszerzające abstrakcję
// i nic więcej
//==================

class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Car:");
        workshop1.performWork();
        workshop2.performWork();
    }
}

class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Bike:");
        workshop1.performWork();
        workshop2.performWork();
    }
}

class BridgePatternDemo {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();

        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();

        //TODO zmień tak żeby Car i Bike miały różną liczbę warsztatów (użyj kolekcji)
    }
}