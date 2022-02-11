package edu.sda.sample.patterns.behavioral.chain;

public class ChainDemo {

    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.addEmployee("Jan Kowalski", 8);
        employees.addEmployee("Maria Wiatr", 6);
        employees.addEmployee("Jan Leśny", 12);

        AccessCheck accessCheck = new CompanyWorkerCheck();
        accessCheck.addChainElement(new EmployeeSeniorityCheck());

        MyCompany myCompany = new MyCompany();
        myCompany.setAccessCheck(accessCheck);

        System.out.println("===============================");
        myCompany.enterRoom("Jan Nowak");
        System.out.println("===============================");
        myCompany.enterRoom("Jan Kowalski");
        System.out.println("===============================");
        myCompany.enterRoom("Maria Wiatr");
        System.out.println("===============================");
        myCompany.enterRoom("Jan Leśny");
        System.out.println("===============================");
    }
}
