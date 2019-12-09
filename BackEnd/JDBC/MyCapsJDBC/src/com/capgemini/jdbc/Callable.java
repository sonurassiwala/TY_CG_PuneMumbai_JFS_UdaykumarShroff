package com.capgemini.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Callable
{
	public static void main(String[] args)
			{
		Connection conn= null;
		Scanner sc= new Scanner(System.in);
		CallableStatement cstmt  =null;
	    ResultSet rs= null;
		
		
		try {
			// Load the drivers
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers loaded");
			System.out.println("***************");
			
			//Get the connection
			String dbUrl = "jdbc:mysql://localhost:3307/capg_db?user=root&password=root";
			System.out.println("Enter the user and password");
			String user= sc.nextLine();
			String password= sc.nextLine();
			
			conn=DriverManager.getConnection(dbUrl,user,password);
			System.out.println("connection established");
			System.out.println("***********************");
			
			//issue the SQL query
			String query ="call getAllInfo()";
			cstmt = conn.prepareCall(query);
			boolean b= cstmt.execute();
			
			if(b)
			{
				rs= cstmt.getResultSet();
				while(rs.next())
				{
					
					System.out.println("User Id:"+rs.getInt("userid"));
					System.out.println("User Name:"+rs.getString("username"));
					System.out.println("Email: "+rs.getString("email"));
					System.out.println("Password:"+rs.getString("password"));
					System.out.println("********************");
				}
			}
			else {
				int i =cstmt.getUpdateCount();
				if(i>0)
				{
					System.out.println("Operation Successful");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			finally
			{
				if(conn!=null)
				{
				try {
						conn.close();
					} 
				catch (SQLException e) 
				{
						e.printStackTrace();
					}
				
				}
				if(cstmt!= null)
				{
					try {
						cstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(rs!= null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		sc.close();
			}
}
