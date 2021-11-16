package edu.sda.sample.threads.basics;

import static edu.sda.sample.threads.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnable sample working");
    }
}
