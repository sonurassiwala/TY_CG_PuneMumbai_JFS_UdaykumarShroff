package com.capgemini.medicaljdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.CartTableBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;

public class CartTableDAOImli implements CartTableDAO {
	
	FileReader reader = null;
	Properties prop = null;
	MedicineBean bean = null;
	CartTableBean cartTableBean=null;

	public CartTableDAOImli() {
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
	public boolean addToCartTable(CartTableBean cartTableBean) {
		
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addToCartTable"))) {
			{
				pstmt.setInt(1, cartTableBean.getmId());
				pstmt.setInt(2, cartTableBean.getOrderId());
				
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
