package edu.sda.sample.patterns.behavioral.chain;

public class CompanyWorkerCheck extends AccessCheck {
    @Override
    public boolean doCheck(String username) {
        System.out.println(CompanyWorkerCheck.class.getSimpleName() + "check for : " + username);
        if(Employees.checkEmployee(username)) {
            System.out.println(CompanyWorkerCheck.class.getSimpleName() + " PASSED for : " + username);
            return checkNextElement(username);
        }

        System.out.println(CompanyWorkerCheck.class.getSimpleName() + " FAILED for : " + username);
        return false;
    }
}
