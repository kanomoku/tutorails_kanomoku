package designPattern.patterns10_FacadeDesignPattern.Interfaces;

import java.sql.Connection;

public class OracleHelper {

	public static Connection getOracleDBConnection(){
		//get Oracle DB connection using connection parameters
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, Connection con){
		//get data from table and generate pdf report
		System.out.println("生成  Oracle PDF"+tableName +"Report");
	}
	
	public void generateOracleHTMLReport(String tableName, Connection con){
		//get data from table and generate html report
		System.out.println("生成  Oracle PDF"+tableName +"Report");
	}
}
