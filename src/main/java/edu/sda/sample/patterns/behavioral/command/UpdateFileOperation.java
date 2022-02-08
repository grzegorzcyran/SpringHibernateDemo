package edu.sda.sample.patterns.behavioral.command;

public class UpdateFileOperation implements FileOperation {
    private MyFile myFile;

    public UpdateFileOperation(MyFile myFile) {
        this.myFile = myFile;
    }

    @Override
    public String performOperation(String content) {
        System.out.println("Performing file update by class:" + UpdateFileOperation.class.getSimpleName());
        return myFile.updateFileContent(content);
    }
}
