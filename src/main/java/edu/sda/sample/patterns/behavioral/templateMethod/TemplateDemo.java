package edu.sda.sample.patterns.behavioral.templateMethod;

public class TemplateDemo {
    public static void main(String[] args) {
        NewsProvider provider = new EmailNewsProvider("message one", "aaa@bbb.cc");
        provider.provideNews("aaa@bbb.cc");


    }
}
