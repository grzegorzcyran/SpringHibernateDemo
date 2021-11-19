package edu.sda.sample.threads.notifier;

public class Message {

    private String content;
    private boolean empty = true;

    public synchronized String read() {

        return content;
    }

    public synchronized void write(String newContent) {

    }
}
