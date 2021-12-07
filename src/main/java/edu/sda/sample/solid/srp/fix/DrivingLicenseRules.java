package edu.sda.sample.solid.srp.fix;

public class DrivingLicenseRules {

    public final int DRIVING_LICENSE_MINIMUM_AGE = 18;

    public boolean canGetDrivingLicense(Person person) {
        return person.getAge() >= DRIVING_LICENSE_MINIMUM_AGE;

        //return person.getAge() >= 18; // Magic number czyli liczba która nie wiadomo co oznacza
    }

    public boolean canRide(Person person) {
        return person.getAge() >= 12; //po roku przychodzi ktoś kto tego kodu nie pisał i się
        //zastanawia co oznacza 12
        //następnie zastanawia się czy inne 12 w tej samej klasie to to samo 12 czy inne 12 (np liczba miesięcy)
    }
}
