package edu.sda.sample.patterns.behavioral.observer;

public class MySubscriber implements Observer {
    private String name;
    private Subject topic;

    public MySubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null) {
            System.out.println(name + ": no new message");
        } else {
            System.out.println(name + ": got new message :" + msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }
}
