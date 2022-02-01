package edu.sda.sample.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

    List<Shape> shapes;
    String description;

    public Drawing(String description) {
        shapes = new ArrayList<>();
        this.description = description;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw() {
        System.out.println("Printing " + description + " and it's shapes:");
        shapes.forEach(Shape::draw);
        System.out.println("End of shapes for " + description);
    }
}
