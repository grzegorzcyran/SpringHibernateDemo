package edu.sda.sample.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperationSequenceExecutor {

    private final List<FileOperation> fileOperationHistory = new ArrayList<>();
    private final Map<FileOperation, String> fileOperationQueue = new LinkedHashMap<>();

    public List<String> execute() {
        List<String> operationLog = fileOperationQueue.entrySet().stream()
                .map(each ->  {
                    fileOperationHistory.add(each.getKey());
                    return each.getKey().performOperation(each.getValue());
                })
                .collect(Collectors.toList());

        fileOperationQueue.keySet().removeAll(fileOperationQueue.keySet());

        return operationLog;
    }

    public void add(FileOperation operation, String content) {
        fileOperationQueue.put(operation, content);
    }

    public List<FileOperation> getFileOperationHistory() {
        return fileOperationHistory;
    }
}
