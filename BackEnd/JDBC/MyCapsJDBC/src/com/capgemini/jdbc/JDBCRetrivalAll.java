package com.capgemini.jdbc;

import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.sql.Connection;

public class JDBCRetrivalAll {

	public static void main(String[] args) {

		Connection conn = null;
		FileReader reader = null;
		Properties prop = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Get the connection
		
		try {
			
			//Load the driver
			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver loaded");
			System.out.println("*****************************");
			
			String dburl = prop.getProperty("dburl");
			conn = DriverManager.getConnection(dburl, prop.getProperty("user"), prop.getProperty("password"));
			System.out.println("Connection Established.....");
			System.out.println("***************************");
			
			String query = "SELECT * FROM users_info";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Query Executed");
			System.out.println(" ");
			
			while(rs.next()) {
				System.out.println("User ID : "+rs.getInt(1));
				System.out.println("Username : "+rs.getString("username"));
				System.out.println("Email : "+rs.getString(4));
				System.out.println("Password : "+rs.getString("pswd"));
				System.out.println(" ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {
			if(conn != null) 
			{
				try {
					conn.close();
					} 
				catch (SQLException e) {
					e.printStackTrace();
					}
			}
			
			if(stmt != null) 
			{
				try {
					stmt.close();
					} 
				catch (SQLException e) {
					e.printStackTrace();
					}
			}
			
			if(rs != null) 
			{
				try {
					rs.close();
					} 
				catch (SQLException e){
					e.printStackTrace();
					}
			}
		}
		
		
		
	}

}
