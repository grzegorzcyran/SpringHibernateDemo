package edu.sda.sample.patterns.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        House house1 = new House.HouseBuilder("beton", "YTONG", "blacha").build();

        House house2 = new House.HouseBuilder("bloczki", "MAX", "dachówka")
                .withGarage("wiata").build();

        House house3 = new House.HouseBuilder("beton", "Cegła dziurawka", "papa")
                .withGarden("minidziałka").build();

        House house4 = new House.HouseBuilder("beton", "MAX", "dachówka")
                .withGarden("park z basenem")
                .withGarage("dwustanowiskowy")
                .build();
    }
}
