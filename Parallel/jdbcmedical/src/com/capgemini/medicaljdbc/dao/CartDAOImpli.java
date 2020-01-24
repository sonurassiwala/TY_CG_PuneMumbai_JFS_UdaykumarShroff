package com.capgemini.medicaljdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;

public class CartDAOImpli implements CartDAO {

	FileReader reader = null;
	Properties prop = null;
	MedicineBean bean = null;
	CartBean cart = null;

	public CartDAOImpli() {
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
	public boolean addTOCart(CartBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("AddCart"))) {
			{
				pstmt.setInt(1, bean.getUid());
				pstmt.setInt(2, bean.getMid());
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
	public List<CartBean> getAll(int uid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("getAllCart"));) {
			pstmt.setInt(1, uid);
			List<CartBean> list = new ArrayList<CartBean>();
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null) {
					while (rs.next()) {
						cart = new CartBean();
						cart.setCartId(rs.getInt(1));
						cart.setUid(rs.getInt(2));
						cart.setMid(rs.getInt(3));

						list.add(cart);
					}
					return list;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("You has no Item in cart");
		return null;
	}

	@Override
	public boolean removecart(int cId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("removeCart"));) {
			pstmt.setInt(1, cId);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeAllCart(int uid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("removeAllCart"));) {
			pstmt.setInt(1, uid);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}