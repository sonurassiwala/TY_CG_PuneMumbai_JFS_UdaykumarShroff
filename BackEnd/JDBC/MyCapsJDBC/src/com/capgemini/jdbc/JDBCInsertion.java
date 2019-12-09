package com.capgemini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertion {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;


		try {
			//Load the drivers
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded . . . .");
			System.out.println("*********************");

			//get connections via drivers
			String dbURL = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Connection Established . . . ");
			System.out.println("********************");

			//Issue the SQL queries
			String insrt = "Insert into users_info values(2019008, 'Dhaval', 'dhaval@xyz.com','dhaval@1234')";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(insrt);


			//Process the Results/SQL queries via connection
			if(count > 0) {
				System.out.println("Data Inserted......");
			}


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}	
			}

		}

	}

}
