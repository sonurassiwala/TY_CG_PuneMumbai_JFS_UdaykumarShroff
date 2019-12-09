package com.capgemini.login.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import com.capgemini.login.beans.LoginUserBean;

public class LoginUserDAOJDBCImpl implements LoginUserDAO{
	
	FileReader reader = null;
	Properties prop = null;
	LoginUserBean user;
		
		
	public LoginUserDAOJDBCImpl() {

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
	public LoginUserBean getInfo(int userid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))){
			pstmt.setInt(1, userid);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					user = new LoginUserBean();
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


	@Override
	public LoginUserBean userLogin(int userid, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query3"))){
			pstmt.setInt(1, userid);
			pstmt.setString(2, password);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					user = new LoginUserBean();
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


	@Override
	public List<LoginUserBean> getAllInfo() {
		
		List<LoginUserBean> userlist = new ArrayList<LoginUserBean>();
		
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password"));
				Statement pstmt = conn.createStatement();
				ResultSet rs = pstmt.executeQuery(prop.getProperty("query"))){
				while(rs.next()) {
					user = new LoginUserBean();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setEmail(rs.getString(3));
					userlist.add(user);
				
				}
				return userlist;
				
			
			
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		
		return null;
		
	}


	

	
}

