package designPattern.designPatterns10_FacadeDesignPattern;

import java.sql.Connection;

public class A1_MySqlHelper {

	public static Connection getMySqlDBConnection() {
		// get MySql DB connection using connection parameters
		return null;
	}

	public void generateMySqlPDFReport(String tableName, Connection con) {
		// get data from table and generate pdf report
		System.out.println("生成  MySql PDF"+tableName +"Report");
	}

	public void generateMySqlHTMLReport(String tableName, Connection con) {
		// get data from table and generate html report
		System.out.println("生成  MySql HTML"+tableName +"Report");
	}
}
