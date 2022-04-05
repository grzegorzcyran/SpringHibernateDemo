package testSample;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers){
        /**
         * TDD zakłada że na początku pisze się test który się wywala
         * Następnie dorabia się kod który powoduje że test przechodzi
         * Ostatnim krokiem jest refactor kodu, czyli jego uproszczenie (albo podział na metody i klasy)
         * Wracamy do początku i robimy kolejną iterację
         */
        if(numbers.length() == 0) {
            return 0;
        }
        String[] splitted = numbers.split(",");

        return Arrays.stream(splitted)
                .map(Integer::valueOf)
                .reduce(0, (a, b) -> a + b);
    }
}
