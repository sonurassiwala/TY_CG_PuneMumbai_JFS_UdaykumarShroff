package com.capgemini.regex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBDCRegex {

public static void main(String[] args) {
		
		DataVerification dv = new DataVerification();
		
		String dbUrl = "jdbc:mysql://localhost:3306/capg_db?user=root&password=root";

		String sql = "INSERT INTO users_info VALUES(?,?,?,?)";
		

		try(Connection conn = DriverManager.getConnection(dbUrl);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			int count = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the userid...");
			String userid = sc.nextLine();
			boolean b = dv.idVer(userid);
			
			System.out.println("Enter the username...");
			String username = sc.nextLine();
			boolean a = dv.nameVer(username);
				
			System.out.println("Enter the email...");
			String email = sc.nextLine();
			boolean c = dv.emailVer(email);
			
			
			System.out.println("Enter the password...");
			String pass = sc.nextLine();
			boolean d = dv.passVer(pass);
			
			
			sc.close();
			
			if(b&&a&&c&&d) 
			{
				pstmt.setString(1, userid);
				pstmt.setString(2, username);
				pstmt.setString(3, email);
				pstmt.setString(4, pass);
				count = pstmt.executeUpdate();
			}
			
			if(count > 0) {
				System.out.println("Data Entered...");
			}else {
				System.err.println("Data Not Entered,  Check For Errors....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
