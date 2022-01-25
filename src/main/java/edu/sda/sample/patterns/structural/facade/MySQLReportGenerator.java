package edu.sda.sample.patterns.structural.facade;

import java.sql.Connection;

public class MySQLReportGenerator {

    public static Connection getConnection() {
        System.out.println("Connecting to MySQL database");
        return null;
    }

    public void generatePDFReportFromMySQL(String table, Connection connection) {
        System.out.println("Creating PDF report from " + table + " with MySQL DB");
    }

    public void generateHTMLReportFromMySQL(String table, Connection connection) {
        System.out.println("Creating HTML report from " + table + " with MySQL DB");
    }
}
