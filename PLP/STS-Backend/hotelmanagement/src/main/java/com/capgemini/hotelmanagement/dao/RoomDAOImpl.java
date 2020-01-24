package com.capgemini.hotelmanagement.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.HistoryBean;
import com.capgemini.hotelmanagement.beans.HotelBean;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.exception.NoBookingsAvailable;
import com.capgemini.hotelmanagement.exception.RoomNotFoundException;
import com.capgemini.hotelmanagement.exception.UnableToAddException;
import com.capgemini.hotelmanagement.exception.UnableToCalculateAmount;
import com.capgemini.hotelmanagement.exception.UserNotFoundException;

@Repository
@SuppressWarnings("unchecked")
public class RoomDAOImpl implements RoomDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean bookHotelRoom(BookingInfoBean bookingInfoBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		boolean isBooked = false;
		try {
			// Checking room is available or not
			boolean isPresent = checkRoomStatus(bookingInfoBean.getRoomId());
			if (isPresent) {
				RoomBean roomBean = entityManager.find(RoomBean.class, bookingInfoBean.getRoomId());
				double roomRent = roomBean.getRoomRent();
				bookingInfoBean.setHotelId(roomBean.getHotelId());
				
				int daysBetween = 0;
				int days = 0;
				// Calculating days between checkin and checkout days
				daysBetween = calculateDays(bookingInfoBean.getCheckinDate(), bookingInfoBean.getCheckoutDate());
				if (daysBetween == 0) {
					days = 1;
				} else {
					days = calculateDays(bookingInfoBean.getCheckinDate(), bookingInfoBean.getCheckoutDate());
				}
				// Calculating total amount
				double totalAmount = days * roomRent;
				System.out.println(totalAmount);
				bookingInfoBean.setAmount(totalAmount);

				entityManager.persist(bookingInfoBean);
				isBooked = true;
				if (isBooked) {
					roomBean.setRoomStatus("Unavailable");
					if (bookingInfoBean.getPaymentStatus().equals("Done")) {
						HistoryBean historyBean = new HistoryBean();
						int hotelId = roomBean.getHotelId();
						historyBean.setHotelId(hotelId);
						HotelBean hotelBean = entityManager.find(HotelBean.class, hotelId);
						// Getting hotel id and hotel name
						historyBean.setHotelName(hotelBean.getHotelName());
						historyBean.setRoomId(bookingInfoBean.getRoomId());
						historyBean.setUserId(bookingInfoBean.getUserId());
						historyBean.setAmount(totalAmount);
						historyBean.setPaymentStatus(bookingInfoBean.getPaymentStatus());
						historyBean.setModeOfPayment(bookingInfoBean.getModeOfPayment());
						historyBean.setCheckinDate(bookingInfoBean.getCheckinDate());
						historyBean.setCheckoutDate(bookingInfoBean.getCheckoutDate());
						saveHistory(historyBean);
					}
				}
				entityTransaction.commit();
			}

		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return isBooked;
	}// End of bookHotel()

	@Override
	public boolean checkRoomStatus(int roomId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean isAvailable = false;
		try {
			// Checking room status
			RoomBean roomBean = entityManager.find(RoomBean.class, roomId);
			if (roomBean.getRoomStatus().equals("Available")) {
				isAvailable = true;
			}

		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return isAvailable;
	}// End of checkRoomStatus()

	@Override
	public List<RoomBean> showAvailableRoom(String roomType) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<RoomBean> roomList = null;
		try {
			String roomStatus = "Available";
			String jpql = "FROM RoomBean WHERE roomStatus =: roomStatus AND roomType =: roomType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("roomStatus", roomStatus);
			query.setParameter("roomType", roomType);
			roomList = query.getResultList();

			entityManager.close();

		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return roomList;
	}// End of showAvailableRoom()

	@Override
	public List<BookingInfoBean> showBooking(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingInfoList = null;
		try {
			String jpql = "FROM BookingInfoBean WHERE userId =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			bookingInfoList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return bookingInfoList;
	}// End of showBooking()

	@Override
	public boolean cancelBooking(int bookingId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isDeleted = false;
		try {
			BookingInfoBean bookingInfoBean = entityManager.find(BookingInfoBean.class, bookingId);
			RoomBean roomBean = entityManager.find(RoomBean.class, bookingInfoBean.getRoomId());
			entityTransaction.begin();
			roomBean.setRoomStatus("Available");
			entityManager.remove(bookingInfoBean);
			isDeleted = true;
			entityTransaction.commit();
		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return isDeleted;
	}// End of deleteBookedRoom()

	@Override
	public int calculateDays(LocalDate checkinDate, LocalDate checkoutDate) {
		int daysBetween = (int) ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		return daysBetween;
	}// End of calculateDays()

	@Override
	public boolean saveHistory(HistoryBean historyBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			entityTransaction.begin();
			entityManager.persist(historyBean);
			entityTransaction.commit();
			isAdded = true;

		} catch (Exception e) {
			throw new UnableToAddException();
		}
		return isAdded;
	}// End of saveHistory

	@Override
	public List<HistoryBean> showHistory(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<HistoryBean> historyList = null;
		try {
			historyList = (List<HistoryBean>) entityManager.find(HistoryBean.class, userId);
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return historyList;
	}// End of showOrder()

	@Override
	public List<RoomBean> showAllRooms() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<RoomBean> roomList = null;
		try {
			String jpql = "FROM RoomBean";
			Query query = entityManager.createQuery(jpql);
			roomList = query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return roomList;
	}

	@Override
	public List<RoomBean> showRooms(int hotelId) {
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
	}

	@Override
	public boolean addNewRoom(RoomBean roomBean) {
		boolean isRoomAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			entityManager.persist(roomBean);
			entityTransaction.commit();
			isRoomAdded = true;

		} catch (Exception e) {
			throw new UnableToAddException();
		}
		entityManager.close();
		return isRoomAdded;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		boolean isRoomDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			RoomBean roomBean = entityManager.find(RoomBean.class, roomId);
			entityManager.remove(roomBean);
			entityTransaction.commit();
			isRoomDeleted = true;

		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		entityManager.close();
		return isRoomDeleted;
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		RoomBean existingRoom = entityManager.find(RoomBean.class, roomBean.getRoomId());
		boolean isUpdated = false;

		if (existingRoom != null) {
			double roomRent = roomBean.getRoomRent();
			if (roomRent > 0) {
				existingRoom.setRoomRent(roomRent);
			}

			String roomType = roomBean.getRoomType();
			if (roomType != null) {
				existingRoom.setRoomType(roomType);
			}

			int roomCapacity = roomBean.getRoomCapacity();
			if (roomCapacity > 0) {
				existingRoom.setRoomCapacity(roomCapacity);
			}

			String roomStatus = roomBean.getRoomStatus();
			if (roomStatus != null) {
				existingRoom.setRoomStatus(roomStatus);
			}
		}

		try {
			entityTransaction.begin();
			entityManager.persist(existingRoom);
			entityTransaction.commit();
			isUpdated = true;

		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return isUpdated;
	}// End of updateRoom()

	@Override
	public RoomBean getRoom(int roomId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		RoomBean roomBean = new RoomBean();
		try {
			roomBean = entityManager.find(RoomBean.class, roomId);
		} catch (Exception e) {
			throw new RoomNotFoundException();
		}
		return roomBean;
	}// End of getRoom()
	
	@Override
	public double getBill(BookingInfoBean bookingInfoBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		double amount = 0.0;
		try {
			int daysBetween = 0;
			int days = 0;
			// Calculating days between checkin and checkout days
			daysBetween = calculateDays(bookingInfoBean.getCheckinDate(), bookingInfoBean.getCheckoutDate());
			if (daysBetween == 0) {
				days = 1;
			} else {
				days = calculateDays(bookingInfoBean.getCheckinDate(), bookingInfoBean.getCheckoutDate());
			}
			
			RoomBean roomBean = entityManager.find(RoomBean.class, bookingInfoBean.getRoomId());
			double roomRent = roomBean.getRoomRent();
			
			// Calculating total amount
			amount = days * roomRent;
			bookingInfoBean.setPaymentStatus("Paid");
			
		} catch (Exception e) {
			throw new UnableToCalculateAmount();
		}
		return amount;
	}//End of getBill()
	
	
	@Override
	public List<HistoryBean> showAllHistory() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<HistoryBean> historyList = null;
		try {
			String jpql = "FROM BookingInfoBean";
			Query query = entityManager.createQuery(jpql);
			historyList = query.getResultList();
		} catch (Exception e) {
			throw new NoBookingsAvailable();
		}
		return historyList;
	}//End of showAllHistory()

}
