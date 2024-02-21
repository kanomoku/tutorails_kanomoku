package designPattern.patterns10_FacadeDesignPattern;

import designPattern.patterns10_FacadeDesignPattern.Facade.HelperFacade;
import designPattern.patterns10_FacadeDesignPattern.Interfaces.MySqlHelper;
import designPattern.patterns10_FacadeDesignPattern.Interfaces.OracleHelper;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        String tableName = "Employee";

        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        System.out.println("**************************");

        //generating MySql HTML report and Oracle PDF report using Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }
}
