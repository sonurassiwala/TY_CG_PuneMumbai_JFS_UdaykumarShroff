package com.capgemini.jdbc;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class JDBCDynUpdate
	{
		public static void main(String[] args) 
		{
			Connection conn=null;
			PreparedStatement pstmt= null;
			Scanner sc= new Scanner(System.in);
			//Load the Driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Loaded...");
				System.out.println("********************");
			
			// Get the connection
				String dburl = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";
				System.out.println("enter the username and password");
				String user= sc.nextLine();
				String password= sc.nextLine();
				
				
				conn= DriverManager.getConnection(dburl,user,password);
				
				System.out.println("Connection established");
				System.out.println("*********************");
				
				//Issue the sql query
				
				String query="UPDATE users_info set email=? where userid=? ";
				pstmt= conn.prepareStatement(query);
				
				System.out.println("Enter the email:");
				pstmt.setString(1,sc.nextLine());
				
				System.out.println("Enter the userid: ");
				pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
				
				
				
				
			int count=pstmt.executeUpdate();
				//process the results
				if(count >0)
				{
					System.out.println("Data Updated.....");
				}
				
				
			}
			catch (Exception e) {
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
				if(pstmt!= null)
				{
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
			}
		}
			sc.close();

		}
	}

