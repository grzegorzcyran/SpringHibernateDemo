package edu.sda.sample.patterns.behavioral.command;

public class MyFile {

    private String fileName;
    private String content;

    public MyFile(String fileName) {
        this.fileName = fileName;
    }

    public String createFileContent(String content) {
        this.content = content;
        return "Created content : " + content + " : for file : " + fileName;
    }

    public String updateFileContent(String content) {
        this.content += content;
        return "Appended content : " + content + " \nto be : "+ this.content + " \n: to file : " + fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }
}
