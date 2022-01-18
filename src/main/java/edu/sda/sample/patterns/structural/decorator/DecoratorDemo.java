package edu.sda.sample.patterns.structural.decorator;

public class DecoratorDemo {

    public static void main(String[] args) {

        Car basicCar = new BaseCar("Czerwony");
        basicCar.assemble();

        System.out.println("===========================");

        Car basicCar2 = new BaseCar("żółty");
        Car sportCar = new SportPack(basicCar2, true, false);
        sportCar.assemble();

        System.out.println("===========================");

        Car basicCar3 = new BaseCar("niebieski");
        WinterPack winterCar = new WinterPack(basicCar3, true, true);
        winterCar.assemble();
        System.out.println("===========================");

        Car basicCar4 = new BaseCar("czarny");
        WinterPack winterCar2 = new WinterPack(basicCar4, false, true);
        SportPack sportWinterCar = new SportPack(winterCar2, false, true);
        sportWinterCar.assemble();
        System.out.println("===========================");

        WinterPack winterCar3 = new WinterPack(
                new SportPack(new BaseCar("biały"), true, false)
                , true, true);
        winterCar3.assemble();

    }
}
