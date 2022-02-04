package edu.sda.sample.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public MyTopic() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(observer == null) {
            throw new NullPointerException("Object is null");
        }

        if(!observers.contains(observer)) {
            System.out.println("Dodajemy observera :" + observer);
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        if(observers.contains(observer)){
            System.out.println("Usuwamy obserwera :" + observer);
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        if(!changed) {
            return;
        }
        //lokalna kopia listy zapisanych na powiadomienia
        //widoczna tylko w zakresie metody
        List<Observer> localList = new ArrayList<>(this.observers);
        //powiadamiamy każdego zapisanego o nowej treści
        localList.forEach(Observer::update);
        //po wysłaniu powiadomień zmieniamy flagę żeby przypadkowo nie wysłać powiadomień ponownie
        changed = false;
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    //jakoś trzeba wrzucać nową treść
    public void postMessge(String message) {
        System.out.println("Nowa treść: " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}
