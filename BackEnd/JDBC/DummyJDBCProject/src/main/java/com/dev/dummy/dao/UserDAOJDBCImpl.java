package com.dev.dummy.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.dev.dummy.bean.UserBeanLombok;

public class UserDAOJDBCImpl implements UserDAO {
	UserBeanLombok user;
	FileReader reader;
	Properties prop;
	Scanner sc = new Scanner(System.in);

	public UserDAOJDBCImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("jdbc.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserBeanLombok> getAllInfo() {
		List<UserBeanLombok> list = new ArrayList<UserBeanLombok>();
		String query = "SELECT * FROM users_info";
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				user = new UserBeanLombok();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserBeanLombok getInfo(int userid) {
		String query = "SELECT * FROM users_info where userid = ?";
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, userid);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = new UserBeanLombok();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setEmail(rs.getString(3));
				}
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertUser(UserBeanLombok user) {
		String query = "INSERT INTO users_info values(?,?,?,?)";
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser( String password) {
		String query = "Delete from users_info where userid = ? and password = ?";
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password")); PreparedStatement pstmt = conn.prepareStatement(query))
		{
			System.out.println("Enter the userid: ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the Password: ");
			pstmt.setString(4, sc.nextLine());
							
			
		int count=pstmt.executeUpdate();
			//process the results
			if(count >0)
			{
				System.out.println("Data Deleted.....");
			}
		} 
		catch (SQLException e) {
					e.printStackTrace();
				}
		return false;
	}
}
