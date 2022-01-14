package edu.sda.sample.patterns.structural.proxy;

class PrivateCompanyInternetNetwork implements CompanyInternetNetwork {

    private String username;

    PrivateCompanyInternetNetwork(String username) {
        this.username = username;
    }

    @Override
    public void getAccess(String username) {
        System.out.println("Private Network access granted to " + username);
    }
}
