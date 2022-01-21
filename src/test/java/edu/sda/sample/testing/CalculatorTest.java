package edu.sda.sample.testing;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    static Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);
    SoftAssertions softly; // pozwala na wykonanie wszystkich asercji w metodzie testowej
    //i dopiero później zwraca wynik (błąd / OK)
    Calculator calculator;

    //wykonywana raz przed uruchomieniem
    @BeforeAll
    static void setup() {
        LOGGER.info(() -> "SETUP ALL launched");
    }

    //metoda wykonana przed każdym testem
    @BeforeEach
    void setupEach() {
        LOGGER.info(() -> "SetupEach launched");
        calculator = new Calculator();
        softly = new SoftAssertions();
    }

    @Test
    void testAddMethodTrue() {
        LOGGER.info(() -> "Add method test");
        //given
        //calculator = new Calculator(); teraz inicjowane w @BeforeEach
        double a = 3.0;
        double b = 5.0;

        //when
        double result = calculator.add(a, b);

        //then
        //JUnit assertion
        assertEquals(8.0, result);

        //AssertJ assertion
        assertThat(result).as("Wynik mniejszy niż 9").isLessThan(9.0);
    }

    @Test
    void testSubtract() {
        LOGGER.info(() -> "Substract method test");
        //given
//        softly = new SoftAssertions(); teraz inicjowane w @BeforeEach
//        calculator = new Calculator(); teraz inicjowane w @BeforeEach
        double a = 7.5;
        double b = 5.0;

        //when
        double result = calculator.substract(a, b);

        //then
        softly.assertThat(result).as("Expected result less then 1.0").isLessThan(1.0);
        softly.assertThat(result).as("Expected result should be 2.0").isEqualTo(2.0);
        softly.assertAll();
    }
}