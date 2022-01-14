package edu.sda.sample.patterns.structural.proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyDemo {
    public static void main(String[] args) {

        CompanyEmployees companyEmployees = new CompanyEmployees();
        List<String> employeeList = Arrays.asList("Anna", "Jan", "Jakub");
        companyEmployees.setEmployees(employeeList);

        CompanyInternetNetwork internetNetwork = new ProxyCompanyInternetNetwork();
        internetNetwork.getAccess("Anna");
        internetNetwork.getAccess("Maria");
        internetNetwork.getAccess("Jan");
        internetNetwork.getAccess("Marek");
    }
}
