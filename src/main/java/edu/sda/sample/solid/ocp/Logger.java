package edu.sda.sample.solid.ocp;

public class Logger {
    private LogDestination logDestination;

    public Logger(LogDestination logDestination) {
        this.logDestination = logDestination;
    }

    /**
     * OCP - Open / Close Principle
     * System ma być otwarty na modyfikacje, ale zamknięty na zmiany (w domyśle istniejącego kodu)
     * Czyli system ma pozwalać dopisywać nowe elementy, ale najlepiej w ten sposób
     * żeby nie zakłócać dotychczasowej logiki
     *
     * Wszystko ok, dopóki nie wymyślimy że może chcemy dołożyć kolejny typ logowania (do pliku)
     */

    public void log(String message) throws IllegalArgumentException {
        switch (logDestination) {
            case CONSOLE:
                System.out.println("Writing " + message + " to console");
                break;
            case DB:
                System.out.println("Writing " + message + " to database");
                break;
            /**
             * Jak chcemy obsłużyć FILE to musimy zmodyfikować istniejącą logikę
             * a może mieliśmy testy które zakładały że albo DB, albo Console, albo wyjątek
             * , a dodanie File "wywali" taki test, bo File nie rzuci wyjątkiem
             */
            case FILE:
                System.out.println("File");
                break;
            default:
                throw new IllegalArgumentException("Not supported logging type");
        }
    }
}
