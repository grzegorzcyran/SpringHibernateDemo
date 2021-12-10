package edu.sda.sample.solid.isp.fix;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FileLogger implements ReadableLogger {

    @Override
    public void writeMessage(String message) {
        System.out.println("Writing to file: " + message);
    }

    @Override
    public Collection<String> read() {
        System.out.println("Reading from saved messages");
        return Collections.emptyList();
    }
}
