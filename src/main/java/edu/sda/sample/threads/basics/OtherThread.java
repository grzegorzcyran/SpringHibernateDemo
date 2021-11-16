package edu.sda.sample.threads.basics;

import static edu.sda.sample.threads.ThreadColor.ANSI_BLUE;

public class OtherThread extends Thread {

    /**
     * Żeby wątek na klasie która rozszerza Thread można było uruchomić, to należy nadpisać metodę run()
     * bo to w niej jest to co ma się wykonać w osobnym wątku
     */
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Wątek ma nazwę: " +currentThread().getName());
        System.out.println(ANSI_BLUE + "Other thread in action!");
        otherMethod();
    }

    private void otherMethod() {
        System.out.println(ANSI_BLUE + "Method call possible");
    }
}
