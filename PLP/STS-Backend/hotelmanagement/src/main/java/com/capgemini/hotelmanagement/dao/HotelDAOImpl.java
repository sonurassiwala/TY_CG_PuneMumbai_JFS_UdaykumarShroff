package com.capgemini.hotelmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.HotelBean;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelNotFoundException;
import com.capgemini.hotelmanagement.exception.RoomNotFoundException;
import com.capgemini.hotelmanagement.exception.UnableToAddException;

@Repository
@SuppressWarnings("unchecked")
public class HotelDAOImpl implements HotelDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<HotelBean> showAllHotels() {
		List<HotelBean> hotelList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "FROM HotelBean";
		Query query = entityManager.createQuery(jpql);
		try {
			// Storing the list of result in a list variable
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new HotelNotFoundException();
		}
		return hotelList;
	}

	@Override
	public boolean updateHotelDetails(HotelBean hotelBean) {
		boolean isUpdated = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		HotelBean hotelBean2 = entityManager.find(HotelBean.class, hotelBean.getHotelId());
		// condition whether HotelBean is present or not
		if (hotelBean2 != null) {
			String hotelName = hotelBean.getHotelName();
			if (hotelName != null && !hotelName.isEmpty()) {
				hotelBean2.setHotelName(hotelName);
			}
			String location = hotelBean.getLocation();
			if (location != null && !location.isEmpty()) {
				hotelBean2.setLocation(location);
			}

			try {
				entityTransaction.begin();
				// updating hotel details
				entityManager.persist(hotelBean2);
				entityTransaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				throw new HotelNotFoundException();
			}
			entityManager.close();
		}
		return isUpdated;
	}

	@Override
	public List<HotelBean> searchHotelDetails(String location) {
		List<HotelBean> list = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Query for searching hotel base on location
		String jpql = "FROM HotelBean WHERE location =:location";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("location", location);
		try {
			list = query.getResultList();
		} catch (Exception e) {
			throw new HotelNotFoundException();
		}
		return list;
	}

	@Override
	public HotelBean getHotelDetails(int hotelId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		HotelBean hotelBean = null;
		try {
			entityTransaction.begin();
			// Getting hotel details
			hotelBean = entityManager.find(HotelBean.class, hotelId);
			entityTransaction.commit();
		} catch (Exception e) {
			throw new HotelNotFoundException();
		}
		entityManager.close();
		return hotelBean;
	}

	@Override
	public boolean addHotelDetails(HotelBean hotelBean) {
		boolean isHotelAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			entityManager.persist(hotelBean);
			entityTransaction.commit();
			isHotelAdded = true;

		} catch (Exception e) {
			throw new UnableToAddException();
		}
		entityManager.close();
		return isHotelAdded;
	}

	@Override
	public boolean deleteHotelDetails(int hotelId) {
		boolean isHotelDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {

			entityTransaction.begin();
			HotelBean hotelBean = entityManager.find(HotelBean.class, hotelId);
			// deleting hotel details
			entityManager.remove(hotelBean);
			entityTransaction.commit();
			isHotelDeleted = true;

		} catch (Exception e) {
			throw new HotelNotFoundException();
		}
		entityManager.close();
		return isHotelDeleted;
	}
	
	@Override
	public HotelBean seeManagerHotel(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		HotelBean hotelBean = null;
		try {
			UserBean userBean = entityManager.find(UserBean.class, userId);
			hotelBean = entityManager.find(HotelBean.class, userBean.getHotelId());
		} catch (Exception e) {
			throw new HotelNotFoundException();
		}
		return hotelBean;
	}//End of seeManagerHotel()
	
	@Override
	public List<RoomBean> seeHotelRooms(int hotelId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<RoomBean> roomList = null;
		try {
			String jpql = "FROM RoomBean WHERE hotelId =: hotelId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("hotelId", hotelId);
			roomList = query.getResultList();
		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return roomList;
	}//End of seeHotelRooms()
}
