package edu.sda.sample.testing;

public class StringCalculator {

    public int add(String param) {

        if(param.isEmpty()) {
            return 0;
        }

        return Integer.valueOf(param);
        
    }
}
