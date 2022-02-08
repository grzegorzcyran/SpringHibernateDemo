package edu.sda.sample.patterns.behavioral.command;

public class CreateFileOperation implements FileOperation {
    private MyFile myFile;

    public CreateFileOperation(MyFile myFile) {
        this.myFile = myFile;
    }

    @Override
    public String performOperation(String content) {
        System.out.println("Logging new file content creation from :" + CreateFileOperation.class.getSimpleName());
        return myFile.createFileContent(content);
    }
}
