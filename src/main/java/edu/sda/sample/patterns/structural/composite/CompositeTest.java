package edu.sda.sample.patterns.structural.composite;

public class CompositeTest {
    public static void main(String[] args) {

        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();

        Shape drawing1 = new Drawing("obrazek pierwszy");
        Shape drawing2 = new Drawing("obrazek drugi");

        ((Drawing) drawing1).addShape(triangle1);
        ((Drawing) drawing1).addShape(circle1);
        ((Drawing) drawing2).addShape(triangle2);
        ((Drawing) drawing2).addShape(drawing1);
        ((Drawing) drawing2).addShape(circle2);

        System.out.println("======== Pierwszy rysunek: ==========");
        drawing1.draw();
        System.out.println("======== Drugi rysunek: ==========");
        drawing2.draw();
        System.out.println("======== Proste kółko: ==========");
        circle2.draw();

    }
}
