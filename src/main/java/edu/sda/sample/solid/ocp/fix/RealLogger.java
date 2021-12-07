package edu.sda.sample.solid.ocp.fix;

public class RealLogger {

    //Message logger to miejsce gdzie wysyłamy logi - to moze być konsola, może być DB
    private MessageLogger messageLogger;

    public RealLogger(MessageLogger messageLogger) {
        this.messageLogger = messageLogger;
    }

    //Metoda log nie wie gdzie logi pójdą
    //To gdzie zostaną zapisane / wyświetlone zależy od przekazanego do RealLogger
    //obiektu MessageLogger (czyli jaka klasa spełniająca interfejs MessageLogger tu przyjdzie)

    public void log(String message) throws Exception {
        messageLogger.log(message);
    }
}
