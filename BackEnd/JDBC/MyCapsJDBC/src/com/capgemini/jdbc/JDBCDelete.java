package com.capgemini.jdbc;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class JDBCDelete
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
				String dburl = "jdbc:mysql://localhost:3307/capg_db?user=root&password=root";
				conn= DriverManager.getConnection(dburl);
				System.out.println("Connection established");
				System.out.println("*********************");
				
				//Issue the sql query
				
				String query="DELETE FROM users_info where userid=?";
				pstmt= conn.prepareStatement(query);
				System.out.println("Enter the userid: ");
				pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
								
				
			int count=pstmt.executeUpdate();
				//process the results
				if(count >0)
				{
					System.out.println("Data Deleted.....");
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

