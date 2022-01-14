package edu.sda.sample.patterns.structural.proxy;

public class ProxyCompanyInternetNetwork implements CompanyInternetNetwork {

    CompanyInternetNetwork companyInternetNetwork;

    @Override
    public void getAccess(String username) {
        //1 wersja obsługi "if"
        if(isEmployee(username)) {
            companyInternetNetwork = new PrivateCompanyInternetNetwork(username);
        } else {
            companyInternetNetwork = new PublicCompanyInternetNetwork(username);
        }
        companyInternetNetwork.getAccess(username);

        //2 wersja obsługi "if"
//        if(isEmployee(username)) {
//            companyInternetNetwork = new PrivateCompanyInternetNetwork(username);
//            return;
//        }
//        companyInternetNetwork = new PublicCompanyInternetNetwork(username);
    }

    private boolean isEmployee(String username) {
        return CompanyEmployees.isEmployee(username);
    }
}
