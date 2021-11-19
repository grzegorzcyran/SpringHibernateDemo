package edu.sda.sample.threads.counter;

public class ThreadCounterDemo {
    public static void main(String[] args) {

        Counter counter = new Counter();

        ThreadCounter threadCounter1 = new ThreadCounter(counter);
        ThreadCounter threadCounter2 = new ThreadCounter(counter);

        threadCounter1.setName("Thread1");
        threadCounter2.setName("Thread2");

        threadCounter1.start();
        threadCounter2.start();
    }
}
