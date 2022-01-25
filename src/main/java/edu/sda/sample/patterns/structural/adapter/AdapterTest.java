package edu.sda.sample.patterns.structural.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        AmericanMovable jeep = new Jeep("Renegade", 160);
        //AmericanCar jeep = new Jeep("Renegade", 160);
        //Jeep jeep = new Jeep("Renegade", 160);
        AmericanMovable dodge = new Dodge("Caliber", 170);

        Volvo volvo = new Volvo("V50", 220);

        System.out.println("Jeep "+ ((Jeep) jeep).getName()+ ", max speed: " + jeep.getSpeed() + "MPH"); //MPH
        System.out.println("Dodge "+ ((Dodge) dodge).getName()+ ", max speed: " + dodge.getSpeed() + "MPH"); //MPH
        System.out.println("Volvo " + volvo.getName() + ", max speed: " + volvo.getSpeed() + "KMH"); //KMH

        //Jak chcemy porównać prędkości to wypada zrobić przelicznik czyli ADAPTER
        System.out.println("Jeep "+ ((Jeep) jeep).getName()+ ", max speed: " +  ((Jeep) jeep).getSpeedKMH() + "KMH");
    }

}
