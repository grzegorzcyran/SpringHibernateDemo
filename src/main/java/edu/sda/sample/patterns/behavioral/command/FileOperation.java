package edu.sda.sample.patterns.behavioral.command;

@FunctionalInterface
public interface FileOperation {
    String performOperation(String content);
}
