package com.capgemini.medicaljdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.medicaljdbc.bean.UserBean;

public class UserDAOImpli implements UserDAO {

	FileReader reader = null;
	Properties prop = null;
	UserBean user = null;

	public UserDAOImpli() {
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
	public boolean registerUser(String username, String email, String password) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {
			{
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				int rs = pstmt.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserBean loginUser(String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginquery"))) {
			{
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs != null) {
						if (rs.next()) {
							user = new UserBean();
							user.setUserId(rs.getInt(1));
							user.setUserName(rs.getString(2));
							user.setUserEmail(rs.getString(3));
							user.setUserPassword(rs.getString(4));
							user.setUserType(rs.getString(5));
							return user;
						}
					} else {
						return null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean adminRegisterUser(String username, String email, String password, String type) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("adminregisetrquery"))) {
			{
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.setString(4, type);
				int rs = pstmt.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserBean> getuser() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAllquery"))) {
			List<UserBean> list = new ArrayList<UserBean>();
			if (rs != null) {
				while (rs.next()) {
					user = new UserBean();
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserEmail(rs.getString(3));
					user.setUserPassword(rs.getString(4));
					user.setUserType(rs.getString(5));
					list.add(user);
				}
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean removeUser(int uId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("removeQuery"))) {
			{
				pstmt.setInt(1, uId);
				int rs = pstmt.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePass(UserBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("changeQuery"))) {
			{
				pstmt.setString(1, bean.getUserPassword());
				pstmt.setInt(2, bean.getUserId());
				int rs = pstmt.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
