package edu.sda.sample.patterns.behavioral.observer;

public interface Observer {

    void update();

    void setSubject(Subject subject);
}
