package edu.sda.sample.patterns.behavioral.templateMethod;

public abstract class NewsProvider {

    private String message;

    public NewsProvider(String message) {
        this.message = message;
    }

    public abstract boolean authorize(String authorizationData);

    public final boolean sendMessage() {
        System.out.println("Message to be sent: " + message);
        return true;
    }

    public abstract boolean endConnection(String authorizationData);

    public final void provideNews(String authorizationData) {
        if(authorize(authorizationData)) {
            sendMessage();
            endConnection(authorizationData);
        }
    }
}

