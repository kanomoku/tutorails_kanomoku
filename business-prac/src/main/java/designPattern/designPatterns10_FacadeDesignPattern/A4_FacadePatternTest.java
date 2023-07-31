package designPattern.designPatterns10_FacadeDesignPattern;

import java.sql.Connection;

public class A4_FacadePatternTest {

	public static void main(String[] args) {
		String tableName="Employee";
		
		//generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = A1_MySqlHelper.getMySqlDBConnection();
		A1_MySqlHelper mySqlHelper = new A1_MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		
		Connection con1 = A2_OracleHelper.getOracleDBConnection();
		A2_OracleHelper oracleHelper = new A2_OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		
		System.out.println("**************************");
		
		//generating MySql HTML report and Oracle PDF report using Facade
		A3_HelperFacade.generateReport(A3_HelperFacade.DBTypes.MYSQL, A3_HelperFacade.ReportTypes.HTML, tableName);
		A3_HelperFacade.generateReport(A3_HelperFacade.DBTypes.ORACLE, A3_HelperFacade.ReportTypes.PDF, tableName);
	}

}
