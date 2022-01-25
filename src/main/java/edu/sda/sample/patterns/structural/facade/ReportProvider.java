package edu.sda.sample.patterns.structural.facade;

import java.sql.Connection;

public class ReportProvider {

    public enum DBType {
        MYSQL,
        ORACLE;
    }

    public enum ReportType {
        HTML,
        PDF
    }

    public static void generateReport(DBType dbType, ReportType reportType, String table) {

        Connection connection = null;
        switch (dbType) {
            case MYSQL:
                connection = MySQLReportGenerator.getConnection();
                MySQLReportGenerator reportGenerator = new MySQLReportGenerator();
                switch (reportType) {
                    case PDF:
                        reportGenerator.generatePDFReportFromMySQL(table, connection);
                        break;
                    case HTML:
                        reportGenerator.generateHTMLReportFromMySQL(table, connection);
                        break;
                }
                break;
            case ORACLE:
                connection = OracleReportGenerator.getConnection();
                OracleReportGenerator reportGenerator1 = new OracleReportGenerator();
                switch (reportType) {
                    case HTML:
                        reportGenerator1.generateHTMLReportFromOracle(table, connection);
                        break;
                    case PDF:
                        reportGenerator1.generatePDFReportFromOracle(table, connection);
                        break;
                }

        }
    }
}
