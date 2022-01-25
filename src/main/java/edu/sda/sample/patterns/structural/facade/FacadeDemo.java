package edu.sda.sample.patterns.structural.facade;

import java.sql.Connection;

public class FacadeDemo {

    public static void main(String[] args) {
        System.out.println("Classic way report calling");

        //=========MySQL
        Connection mySQLConnection = MySQLReportGenerator.getConnection();
        MySQLReportGenerator mySQLReportGenerator = new MySQLReportGenerator();
        mySQLReportGenerator.generatePDFReportFromMySQL("Customers", mySQLConnection);

        //=========Oracle
        Connection oracleConnection = OracleReportGenerator.getConnection();
        OracleReportGenerator oracleReportGenerator = new OracleReportGenerator();
        oracleReportGenerator.generatePDFReportFromOracle("Customers", oracleConnection);

        //FACADE
        System.out.println("Facade usage");
        ReportProvider.generateReport(ReportProvider.DBType.ORACLE
        , ReportProvider.ReportType.HTML, "customers");

    }
}
