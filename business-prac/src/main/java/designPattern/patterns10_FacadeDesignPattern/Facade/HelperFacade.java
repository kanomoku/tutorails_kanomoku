package designPattern.patterns10_FacadeDesignPattern.Facade;

import designPattern.patterns10_FacadeDesignPattern.Interfaces.MySqlHelper;
import designPattern.patterns10_FacadeDesignPattern.Interfaces.OracleHelper;

import java.sql.Connection;

public class HelperFacade {

    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        Connection con = null;
        switch (dbType) {
            case MYSQL -> {
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML -> mySqlHelper.generateMySqlHTMLReport(tableName, con);
                    case PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con);
                }
            }
            case ORACLE -> {
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, con);
                        break;
                }
            }
        }

    }

    public enum DBTypes {
        MYSQL, ORACLE;
    }

    public enum ReportTypes {
        HTML, PDF;
    }
}
