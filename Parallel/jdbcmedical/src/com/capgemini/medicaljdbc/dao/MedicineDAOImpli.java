package com.capgemini.medicaljdbc.dao;

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

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;

public class MedicineDAOImpli implements MedicineDAO {

	FileReader reader = null;
	Properties prop = null;
	MedicineBean bean = null;

	public MedicineDAOImpli() {
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
	public boolean addMedicine(MedicineBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("medicineAddQuery"))) {
			{
				pstmt.setString(1, bean.getMedicine_name());
				pstmt.setDouble(2, bean.getPrice());
				pstmt.setString(3, bean.getProduct_category());
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
	public List<MedicineBean> viewmedicine() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getMedicinequery"))) {
			List<MedicineBean> list = new ArrayList<MedicineBean>();
			if (rs != null) {
				while (rs.next()) {
					bean = new MedicineBean();
					bean.setMedicine_code(rs.getInt(1));
					bean.setMedicine_name(rs.getString(2));
					bean.setPrice(rs.getDouble(3));
					bean.setProduct_category(rs.getString(4));
					list.add(bean);
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
	public boolean removeMedicine(int mId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("removeMedQuery"))) {
			{
				pstmt.setInt(1, mId);
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
	public MedicineBean getMed(int midId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("getmed"));) {
			pstmt.setInt(1, midId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					bean = new MedicineBean();
					bean.setMedicine_code(rs.getInt(1));
					bean.setMedicine_name(rs.getString(2));
					bean.setPrice(rs.getInt(3));
					bean.setProduct_category(rs.getString(4));
					return bean;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateMedicine(int mid, String name) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updatemedicinename"))) {

			pstmt.setString(1, name);
			pstmt.setInt(2, mid);

			if (pstmt.executeUpdate() != 0) {
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
	public boolean updateMedicine(int id, double price) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updatemedicineprice"))) {

			pstmt.setDouble(1, price);
			pstmt.setInt(2, id);

			if (pstmt.executeUpdate() != 0) {
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
	public boolean updateMedicinedescription(int mid, String catgeory) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updatemedicinedescription"))) {

			pstmt.setString(1, catgeory);
			pstmt.setInt(2, mid);

			if (pstmt.executeUpdate() != 0) {
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
