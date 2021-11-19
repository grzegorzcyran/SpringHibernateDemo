package edu.sda.sample.threads.counter;

import static edu.sda.sample.threads.ThreadColor.*;

public class Counter {

    private int index;

    public void performCountdown() {
        String colorName;
        switch (Thread.currentThread().getName()) {
            case "Thread1" :
                colorName = ANSI_CYAN;
                break;
            case "Thread2" :
                colorName = ANSI_PURPLE;
                break;
            default:
                colorName = ANSI_BLUE;
        }

        /**
         * poniżej synchronizujemy cały obiekt (this)
         * może być tak że synchronized będzie też na polu klasy
         * - ale to pole musi być obiektowe
         * ważne jest że ten synchronizowany obiekt to ma być to co
         * wpływa na nasz kod który chcemy zabezpieczyć
         * przed "wyrywaniem go sobie" przez wątki
         */

        //synchronized może być na bloku kodu
        synchronized (this) {
            doRealCountdown(colorName);
        }
    }

    //synchronized może być na metodzie
    //private synchronized void doRealCountdown(String color) {
    private void doRealCountdown(String color) {
        for(index = 10; index > 0; index--) {
            System.out.println(color + Thread.currentThread().getName() + " index = " + index);
        }

    }
}
