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

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.OrderBean;

public class OrderDAOImpli implements OrderDAO {
	FileReader reader = null;
	Properties prop = null;
	MedicineBean bean = null;
	OrderBean orderBean = null;

	public OrderDAOImpli() {
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
	public boolean placeOrder(OrderBean orderBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("AddtoOrder"))) {
			{
				pstmt.setDouble(1, orderBean.getPrice());
				pstmt.setInt(2, orderBean.getUid());
				pstmt.setString(3, orderBean.getCardno());
				pstmt.setString(4, orderBean.getAdress());
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
	public int getMax() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getmaxId"))) {
			{
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<OrderBean> getAll(int uid) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("getAllOrder"));) {
			pstmt.setInt(1, uid);
			List<OrderBean> list = new ArrayList<OrderBean>();
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null) {
					while (rs.next()) {
						orderBean = new OrderBean();
						orderBean.setOrderId(rs.getInt(1));
						orderBean.setPrice(rs.getDouble(2));
						orderBean.setUid(rs.getInt(3));
						orderBean.setCardno(rs.getString(4));
						orderBean.setAdress(rs.getString(5));
						list.add(orderBean);
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

}
