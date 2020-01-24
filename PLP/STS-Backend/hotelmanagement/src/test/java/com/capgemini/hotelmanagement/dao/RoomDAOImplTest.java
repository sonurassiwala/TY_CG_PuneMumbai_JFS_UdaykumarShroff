package com.capgemini.hotelmanagement.dao;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.HistoryBean;
import com.capgemini.hotelmanagement.beans.RoomBean;

import junit.framework.TestCase;

@SpringBootTest
class RoomDAOImplTest {

	@Autowired
	private RoomDAO roomDAO;
	
	@Test
	void testBookHotelRoom() throws ParseException {
		BookingInfoBean bookingInfoBean = new BookingInfoBean();
		bookingInfoBean.setRoomId(20);
		bookingInfoBean.setHotelId(6);
		LocalDate checkinDate = LocalDate.parse("2019-12-30");
		LocalDate checkoutDate = LocalDate.parse("2019-12-31");
		bookingInfoBean.setCheckinDate(checkinDate);
		bookingInfoBean.setCheckoutDate(checkoutDate);
		TestCase.assertTrue(roomDAO.bookHotelRoom(bookingInfoBean));
	}

	@Test
	void testCheckRoomStatus() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomStatus("Available");
		TestCase.assertTrue(roomDAO.checkRoomStatus(20));
	}

	@Test
	void testShowAvailableRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomStatus("Available");
		roomBean.setRoomType("Single");
		TestCase.assertNotNull(roomDAO.showAvailableRoom("Single"));
	}

	@Test
	void testShowBooking() {
		TestCase.assertNotNull(roomDAO.showBooking(1));
	}

	@Test
	void testCancelBooking() {
		TestCase.assertNotNull(roomDAO.cancelBooking(1));
	}
	
	@Test
	void testCalculateDays() {
		LocalDate checkinDate = LocalDate.parse("2019-12-30");
		LocalDate checkoutDate = LocalDate.parse("2019-12-31");
		TestCase.assertNotNull(roomDAO.calculateDays(checkinDate, checkoutDate));
	}

	@Test
	void testSaveHistory() {
		HistoryBean historyBean = new HistoryBean();
		historyBean.setHotelId(6);
		historyBean.setHotelName("Taj");
		historyBean.setRoomId(19);
		historyBean.setUserId(2);
		historyBean.setModeOfPayment("Debit card");
		LocalDate checkinDate = LocalDate.parse("2019-12-30");
		LocalDate checkoutDate = LocalDate.parse("2019-12-31");
		historyBean.setCheckinDate(checkinDate);
		historyBean.setCheckoutDate(checkoutDate);
		historyBean.setPaymentStatus("Done");
		historyBean.setAmount(2000.00);
		TestCase.assertTrue(roomDAO.saveHistory(historyBean));
	}

	@Test
	void testShowHistory() {
		TestCase.assertNull(roomDAO.showHistory(2).isEmpty());
	}

	@Test
	void testShowAllRooms() {
		TestCase.assertNotNull(roomDAO.showAllRooms());
	}

	@Test
	void testShowRooms() {
		TestCase.assertNotNull(roomDAO.showRooms(1001));
	}

	@Test
	void testAddNewRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setHotelId(6);
		roomBean.setRoomType("Single");
		roomBean.setRoomCapacity(1);
		roomBean.setRoomRent(2000.00);
		roomBean.setRoomStatus("Available");
		TestCase.assertTrue(roomDAO.addNewRoom(roomBean));
	}

	@Test
	void testDeleteRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(19);
		TestCase.assertTrue(roomDAO.deleteRoom(roomBean.getRoomId()));
	}

	@Test
	void testUpdateRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(19);
		roomBean.setRoomType("Single");
		roomBean.setRoomCapacity(1);
		roomBean.setRoomRent(2000.00);
		roomBean.setRoomStatus("Booked");
		TestCase.assertTrue(roomDAO.updateRoom(roomBean));
	}

	@Test
	void testGetRoom() {
		TestCase.assertNotNull(roomDAO.getRoom(19));
	}

}
