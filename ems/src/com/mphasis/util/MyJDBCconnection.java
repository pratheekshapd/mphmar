package com.mphasis.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBCconnection {

	static Connection con;
	public static Connection getDBConnection()
	{
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","pratheeksha");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}	
	
	public static void main(String[] args) {
		System.out.println(getDBConnection());

	}

}