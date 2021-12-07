package edu.sda.sample.solid.ocp.fix;

public class LoggerDemo {

    /**
     * Tu robimy demo / prezentację jak te loggery działają
     */

    public static void main(String[] args) {
        //1. Decydujemy że MessageLogger to będzie konsola
        MessageLogger messageLogger = new ConsoleLogger();
        //2. Wrzucamy konsolę jako parametr do RealLoggera
        RealLogger realLogger = new RealLogger(messageLogger);

        try {
            realLogger.log("AAAAA");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
