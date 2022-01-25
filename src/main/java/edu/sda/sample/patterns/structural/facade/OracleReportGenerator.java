package edu.sda.sample.patterns.structural.facade;

import java.sql.Connection;

public class OracleReportGenerator {

    public static Connection getConnection() {
        System.out.println("Connecting to Oracle database");
        return null;
    }

    public void generatePDFReportFromOracle(String table, Connection connection) {
        System.out.println("Creating PDF report from " + table + " with Oracle DB");
    }

    public void generateHTMLReportFromOracle(String table, Connection connection) {
        System.out.println("Creating HTML report from " + table + " with Oracle DB");
    }
}
