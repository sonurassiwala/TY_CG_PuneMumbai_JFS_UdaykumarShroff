package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.capgemini.jdbc.beans.UserBean;

public class UserDAOJDBCImpl implements UserDAO {

	FileReader reader = null;
	Properties prop = null;
	UserBean user;
	
	
	public UserDAOJDBCImpl() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserBean getInfo(int userid) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))){
			pstmt.setInt(1, userid);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					user = new UserBean();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setEmail(rs.getString(3));
				
				}
				return user;
				
			} 
			catch (Exception e) {
			}
			
		} 
		catch (Exception e) {
		
		}
		
		return null;
	}

	
	
	
}
