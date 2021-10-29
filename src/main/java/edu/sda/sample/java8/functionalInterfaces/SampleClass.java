package edu.sda.sample.java8.functionalInterfaces;

public class SampleClass implements OldStyleInterface, SampleFunctionalInterface {

    @Override
    public void firstMethod() {
        System.out.println("We need and want that method");
    }

    @Override
    public void secondMethod() {
        throw new RuntimeException();
    }

    //Method from functional interface

    @Override
    public void sampleAbstractMethod() {
        System.out.println("Required implementation");
    }


}
