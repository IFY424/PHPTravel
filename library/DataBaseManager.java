package com.selenium.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseManager {
	private String databaseServerName="localhost";
	private String databasePort="1521";// usually same for the all company,unless you changed
	private String DatabaseName="xe";
	private String userName="HR";
	private String userPassWord="system";
	private String connectionURL="jdbc:oracle:thin:hr@//"+databaseServerName+":"+databasePort
     +"/"+DatabaseName;
	
	private ResultSet resultSet=null;
	private Statement statement=null;
	private Connection connection=null;
	
	private void connectToOracleDB()throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		connection=DriverManager.getConnection(connectionURL, userName, userPassWord);
		statement=connection.createStatement();
	}
	
	public ResultSet runSQLQuery(String sqlQuery) throws Exception{
		connectToOracleDB();
		resultSet=statement.executeQuery(sqlQuery);
		return resultSet;
		
		
	}
	
	public static void main(String[] args) throws Exception{
		DataBaseManager dbManager=new DataBaseManager();
		ResultSet data=dbManager.runSQLQuery("Select* from Countries");
		System.out.println("data:"+data);
		while(data.next()){
			String countryID=data.getString("COUNTRY_ID");
			String countryName=data.getString("COUNTRY_NAME");
			int regionID= data.getInt("REGION_ID");
			System.out.println(countryID+"\t"+countryName+"\t\t\t\t"+regionID);
			
		}
	}
	
	
	
	
}
