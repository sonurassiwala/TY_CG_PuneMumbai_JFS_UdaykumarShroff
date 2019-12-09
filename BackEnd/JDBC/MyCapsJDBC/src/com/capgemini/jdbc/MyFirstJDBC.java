

package com.capgemini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			//Load the driver
			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver loaded");
			System.out.println("*****************************");
			
			//get DB connections via drivers
			String dbURL = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Connection Established");
			System.out.println("*****************************");
			
			//Issue SQL Queries
			String query = "SELECT * FROM users_info";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Query Executed");
			System.out.println(" ");
			
			//Process the SQL queries and give the results
			while(rs.next()) {
				System.out.println("User ID : "+rs.getInt(1));
				System.out.println("Username : "+rs.getString("username"));
				System.out.println("Email : "+rs.getString(4));
				System.out.println("Password : "+rs.getString("pswd"));
				System.out.println(" ");
			}
			
		} 
		catch (SQLException e) 
		{
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
