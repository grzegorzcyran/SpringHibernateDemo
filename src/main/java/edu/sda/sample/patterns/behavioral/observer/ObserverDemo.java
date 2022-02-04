package edu.sda.sample.patterns.behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Observer observer1 = new MySubscriber("Janek");
        Observer observer2 = new MySubscriber("Arek");
        Observer observer3 = new MySubscriber("Wojtek");

        Subject subject = new MyTopic();

        observer1.setSubject(subject);
        observer2.setSubject(subject);

        subject.register(observer1);
        subject.register(observer2);

        System.out.println("=======================");
        ((MyTopic) subject).postMessge("Pierwsza wiadomosc na liste");
        System.out.println("=======================");
        observer3.setSubject(subject);
        subject.register(observer3);
        System.out.println("=======================");
        ((MyTopic) subject).postMessge("Kolejna wiadomosc na liste");
        System.out.println("=======================");
        subject.unregister(observer1);
        subject.unregister(observer3);
        System.out.println("=======================");
        ((MyTopic) subject).postMessge("Ostatnia wiadomosc na liste");
    }
}
