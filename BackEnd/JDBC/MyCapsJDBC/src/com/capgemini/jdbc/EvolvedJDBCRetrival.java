package com.capgemini.jdbc;

import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import java.sql.Connection;

public class EvolvedJDBCRetrival {

	public static void main(String[] args) {

		FileReader reader = null;
		Properties prop = null;
		
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
			System.out.println("Diver is Loaded....");
			System.out.println("----------------------------");
			
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query")))
		{
			while(rs.next()) {
				System.out.println("User ID : "+rs.getInt(1));
				System.out.println("Username : "+rs.getString("username"));
				System.out.println("Email : "+rs.getString(4));
				System.out.println("-----------------------------------------");
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
