package edu.sda.sample.solid.ocp.fix;

public class FileLoggerDemo {
    public static void main(String[] args) {
        MessageLogger messageLogger = new FileLogger();
        RealLogger realLogger = new RealLogger(messageLogger);

        /**
         * Dołożyliśmy nowy sposób logowania - do pliku - nie mieszając w istniejących klasach
         * (z wyjątkiem enuma, ale testów enuma się (*prawie) nie robi)
         *
         * OCP zachowane bo nasza nowa logika pojawia się w nowej klasie
         */

        try {
            realLogger.log("BBB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
