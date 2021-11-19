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

        try {

            /**
             * sleep() może zostać przerwany przez otherThread.interrupt()
             * co spowoduje rzucenie wyjątku InterruptException
             * i przejście od sleep() bezpośrednio do kodu w klauzuli catch() {}
             * czyli wszystko to co jest w try{} ale poniżej sleep() już się nie wykona
             */
            sleep(4000);
            System.out.println(ANSI_BLUE + "Enough sleeping for OtherThread");
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Interrupted work of OtherThread");
        }
    }

    private void otherMethod() {
        System.out.println(ANSI_BLUE + "Method call possible");
    }
}
