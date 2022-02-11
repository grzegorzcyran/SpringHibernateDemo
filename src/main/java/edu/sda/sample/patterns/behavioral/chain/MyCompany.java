package edu.sda.sample.patterns.behavioral.chain;

public class MyCompany {
    private Employees employees;
    private AccessCheck accessCheck;

    public void setAccessCheck(AccessCheck accessCheck) {
        this.accessCheck = accessCheck;
    }

    public boolean enterRoom(String user) {
        if(accessCheck.doCheck(user)) {
            System.out.println("Access granted for : " + user);
            return true;
        }
        System.out.println("DENIED for : " + user);
        return false;
    }
}
