package edu.sda.sample.patterns.behavioral.chain;

public class EmployeeSeniorityCheck extends AccessCheck {
    private final int MINIMUM_EMPLOYEE_LEVEL = 10;

    @Override
    public boolean doCheck(String username) {
        System.out.println(EmployeeSeniorityCheck.class.getSimpleName() + "check for : " + username);
        if(Employees.checkEmployeeLevel(username) >= MINIMUM_EMPLOYEE_LEVEL) {
            System.out.println(EmployeeSeniorityCheck.class.getSimpleName() + " PASSED for : " + username);
            return checkNextElement(username);
        }

        System.out.println(EmployeeSeniorityCheck.class.getSimpleName() + " FAILED for : " + username);
        return false;
    }
}
