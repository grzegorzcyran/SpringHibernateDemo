package edu.sda.sample.threads.basics;

import static edu.sda.sample.threads.ThreadColor.*;

public class MainThread {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Main thread in action");

        OtherThread otherThread = new OtherThread();
        otherThread.setName("=== Nowy osobny wątek ===");

        /**
         * Wątek z klasy OtherThread ma kod do wykonania w osobnym wątku zapisany (albo wywołany)
         * w metodzie run() ALE
         *  - jeśli wywołamy bezpośrednio metodę run() to nie utworzymy nowego wątku tylko po prostu wykonamy ten
         *  kod sekwencyjnie w ramach wątku bieżącego (czyli main)
         *  - żeby wywołać tworzenie i uruchomienie osobnego wątku, wołamy metodę start() - mimo że jej wcale
         *  nie dotykamy (nie modyfikujemy)
         */

        otherThread.start();
//        otherThread.run();

        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();

        /**
         * Wątek uruchamiany na klasie anonimowej
         * Takie rzeczy robi się jak masz jednorazową akcję w kodzie którą chcesz
         * przekazać do osobnego wątku bo np. trwa a nie chcesz blokować głównego okna programu
         */
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class in action");
            }
        }.start();

        runnableSample = new Thread(new RunnableSample() {

            @Override
            public void run() {
                System.out.println(ANSI_RED + " Overwritten RunnableSample thread");
                try {
                    //join() powoduje przejście do wątku na którym metoda jest wywołana
                    //czyli idziemy do otherThread i tamten kod wykonujemy ZANIM przejdziemy dalej w bieżącym wątku (runnableSample)
                    otherThread.join();
                    System.out.println(ANSI_RED + "OtherThread finished and time to continue");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "runnableSample interrupted");
                }
            }
        });

        runnableSample.start();
//        otherThread.interrupt();
        /**
         * interrupt na RunnableSample powoduje że nie czekamy juz na wykonanie kodu z OtherThread -
         * OtherThread sobie wykona to co ma do wykonania (czyli sleep itd)
         * ale RunnableSample w tym czasie już jest przerwany
         */
        //runnableSample.interrupt();

        System.out.println(ANSI_PURPLE + "END OF MAIN THREAD");
    }
}
