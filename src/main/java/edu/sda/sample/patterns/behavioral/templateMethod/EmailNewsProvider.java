package edu.sda.sample.patterns.behavioral.templateMethod;

public class EmailNewsProvider extends NewsProvider {

    String email;

    public EmailNewsProvider(String message, String email) {
        super(message);
        this.email = email;
    }

    @Override
    public boolean authorize(String authorizationData) {
        if(authorizationData.contains("@")){
            return true;
        }
        return false;
    }

    @Override
    public boolean endConnection(String authorizationData) {
        return authorizationData.contains("@");
    }
}

