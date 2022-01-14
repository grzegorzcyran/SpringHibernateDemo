package edu.sda.sample.patterns.creational.prototype;

import java.util.List;

public class PrototypeDemo {
    public static void main(String[] args) {
        //template
        ShoppingList shoppingList = new ShoppingList();

        try {
            ShoppingList todays = (ShoppingList) shoppingList.clone();
            List<String> todaysShoppings = todays.getShoppings();
            todaysShoppings.add("piwo");
            todaysShoppings.add("kiełbaski");
            todays = new ShoppingList(todaysShoppings);

            System.out.println("Break point");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
