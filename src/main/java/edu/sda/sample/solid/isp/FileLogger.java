package edu.sda.sample.solid.isp;

import java.util.Collection;
import java.util.Collections;

/**
 * ISP - Interface Segregation Principle
 * Zasada segregacji interfjsów
 * Chodzi o to że możemy mieć kilka poziomów interfejsów, jedne mogą rozszerzać inne
 * i pisząc nasz kod wykorzystujemy te interfejsy które akurat są nam portzebne
 *
 */


public class FileLogger implements Logger {
    @Override
    public void writeMessage(String message) {
        System.out.println("Writing " + message + " to file.");
    }

    @Override
    public Collection<String> readMessages() {
        return Collections.EMPTY_LIST;
    }
}
