package edu.sda.sample.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator;

    //GIVEN
    @BeforeEach
    void setup() {
        calculator = new StringCalculator();
    }

    @Test
    void testEmptyStringPassed() {
        //given
        String value = "";

        //when
        int result = calculator.add(value);

        //then
        assertThat(result)
                .as("Expected 0 when empty string passed")
                .isEqualTo(0);
    }

    @Test
    void testOneNumberPassed() {
        //given
        String value = "1";

        //when
        int result = calculator.add(value);

        //then
        assertThat(result)
                .isEqualTo(1);
    }

}