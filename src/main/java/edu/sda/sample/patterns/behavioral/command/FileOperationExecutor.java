package edu.sda.sample.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class FileOperationExecutor {

    private final List<FileOperation> fileOperationHistory = new ArrayList<>();

    public String execute(FileOperation operation, String content) {
        fileOperationHistory.add(operation);
        return operation.performOperation(content);
    }

    public List<FileOperation> getFileOperationHistory() {
        return fileOperationHistory;
    }
}
