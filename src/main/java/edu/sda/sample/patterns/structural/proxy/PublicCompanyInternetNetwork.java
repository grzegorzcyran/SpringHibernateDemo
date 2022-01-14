package edu.sda.sample.patterns.structural.proxy;

class PublicCompanyInternetNetwork implements CompanyInternetNetwork {

    private String username;

    PublicCompanyInternetNetwork(String username) {
        this.username = username;
    }

    @Override
    public void getAccess(String username) {
        System.out.println("Public ONLY granted to " + username);
    }
}
