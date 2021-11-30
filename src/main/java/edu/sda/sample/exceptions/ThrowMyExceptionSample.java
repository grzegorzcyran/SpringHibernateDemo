package edu.sda.sample.exceptions;

public class ThrowMyExceptionSample {

    private void myExceptionThrower() {
        int a = 2;
        String b = "bbb";
        if(a == 2) {
            b = "CCC";
        }
        throw new MyException("AAAAA, błąd!!!!!");
    }

    private void myExceptionPasser() {
        myExceptionThrower();
    }

    public static void main(String[] args) {
        ThrowMyExceptionSample sample = new ThrowMyExceptionSample();

        sample.myExceptionPasser();
    }
}
