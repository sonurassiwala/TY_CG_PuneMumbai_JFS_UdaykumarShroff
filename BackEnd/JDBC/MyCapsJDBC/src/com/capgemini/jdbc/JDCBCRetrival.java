package com.capgemini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDCBCRetrival {

	public static void main(String[] args) {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		
		
		try 
		{
			//Load the Drivers
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			System.out.println("*********************");
			
			//get connections via drivers
			String dbURL = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Connection Established . . . ");
			System.out.println("********************");
			
			//Issue the SQL Queries via connections
			String query = "SELECT * FROM users_info where userid = ?"; // if there is a question mark in SQL query then it become the dynamic SQL query
			pstmt = conn.prepareStatement(query); //prepare statement take as a query that is precompiled
			System.out.println("Enter the User-ID : ");
			pstmt.setInt(1, sc.nextInt());
			rs = pstmt.executeQuery();

			//Process the Results
			if(rs.next()) {
				System.out.println("User-ID : "+rs.getInt(1));
				System.out.println("User-Name : "+rs.getString(2));
				System.out.println("Email : "+rs.getString(3));
				System.out.println("Password : "+rs.getString(4));
			}
			else {
				System.out.println("Something went wrong!!!");
			}
			
		}
		
		catch (Exception e) 
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
			
			if(pstmt != null) 
			{
				try {
					pstmt.close();
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
			sc.close();
		}
		
		
	}

}
