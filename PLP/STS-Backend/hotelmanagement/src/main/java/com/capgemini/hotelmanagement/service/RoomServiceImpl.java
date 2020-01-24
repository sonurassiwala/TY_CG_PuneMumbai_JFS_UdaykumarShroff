package com.capgemini.hotelmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.HistoryBean;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.dao.RoomDAO;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;

	@Override
	public boolean bookHotelRoom(BookingInfoBean bookingInfoBean) {
		return roomDAO.bookHotelRoom(bookingInfoBean);
	}

	@Override
	public boolean checkRoomStatus(int roomId) {
		return roomDAO.checkRoomStatus(roomId);
	}

	@Override
	public List<RoomBean> showAvailableRoom(String roomType) {
		return roomDAO.showAvailableRoom(roomType);
	}

	@Override
	public List<BookingInfoBean> showBooking(int userId) {
		return roomDAO.showBooking(userId);
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		return roomDAO.cancelBooking(bookingId);
	}

	@Override
	public boolean saveHistory(HistoryBean historyBean) {
		return roomDAO.saveHistory(historyBean);
	}

	@Override
	public List<HistoryBean> showHistory(int userId) {
		return roomDAO.showHistory(userId);
	}

	@Override
	public List<RoomBean> showAllRooms() {
		return roomDAO.showAllRooms();
	}

	@Override
	public boolean addNewRoom(RoomBean roomBean) {
		return roomDAO.addNewRoom(roomBean);
	}

	@Override
	public boolean deleteRoom(int roomId) {
		return roomDAO.deleteRoom(roomId);
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		return roomDAO.updateRoom(roomBean);
	}

	@Override
	public RoomBean getRoom(int roomId) {
		return roomDAO.getRoom(roomId);
	}

	@Override
	public int calculateDays(LocalDate checkinDate, LocalDate checkoutData) {
		return roomDAO.calculateDays(checkinDate, checkoutData);
	}

	@Override
	public double getBill(BookingInfoBean bookingInfoBean) {
		return roomDAO.getBill(bookingInfoBean);
	}

	@Override
	public List<RoomBean> showRooms(int hotelId) {
		return roomDAO.showRooms(hotelId);
	}

	@Override
	public List<HistoryBean> showAllHistory() {
		return roomDAO.showAllHistory();
	}

}// End of Class
