package testSample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        //given
        calculator = new StringCalculator();
    }
    @Test
    public void emptyStringShoudReturnZero() {
        //when
        int result = calculator.add("");

        //then
        assertEquals( 0, result);
    }

    @Test
    public void oneNumberShouldBeReturned() {
        //when
        int result = calculator.add("1");

        //then
        assertEquals( 1, result);
    }

    @Test
    public void twoNumbersShouldReturnSumOfThem() {
        //when
        int result = calculator.add("1,2");

        //then
        assertEquals( 3, result);
    }
}