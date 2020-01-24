package com.capgemini.hotelmanagement.service;

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
class RoomServiceImplTest {

	@Autowired
	private RoomService roomService;
	
	@Test
	void testBookHotelRoom() throws ParseException {
		BookingInfoBean bookingInfoBean = new BookingInfoBean();
		bookingInfoBean.setRoomId(20);
		bookingInfoBean.setHotelId(6);
		LocalDate checkinDate = LocalDate.parse("2019-12-30");
		LocalDate checkoutDate = LocalDate.parse("2019-12-31");
		bookingInfoBean.setCheckinDate(checkinDate);
		bookingInfoBean.setCheckoutDate(checkoutDate);
		TestCase.assertTrue(roomService.bookHotelRoom(bookingInfoBean));
	}

	@Test
	void testCheckRoomStatus() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomStatus("Available");
		TestCase.assertTrue(roomService.checkRoomStatus(20));
	}

	@Test
	void testShowAvailableRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomStatus("Available");
		roomBean.setRoomType("Single");
		TestCase.assertNotNull(roomService.showAvailableRoom("Single"));
	}

	@Test
	void testShowBooking() {
		TestCase.assertNotNull(roomService.showBooking(1));
	}

	@Test
	void testCancelBooking() {
		TestCase.assertNotNull(roomService.cancelBooking(1));
	}

	@Test
	void testCalculateDays() {
		LocalDate checkinDate = LocalDate.parse("2019-12-30");
		LocalDate checkoutDate = LocalDate.parse("2019-12-31");
		TestCase.assertNotNull(roomService.calculateDays(checkinDate, checkoutDate));
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
		TestCase.assertTrue(roomService.saveHistory(historyBean));
	}

	@Test
	void testShowHistory() {
		TestCase.assertNull(roomService.showHistory(2).isEmpty());
	}

	@Test
	void testShowAllRooms() {
		TestCase.assertNotNull(roomService.showAllRooms());
	}

	@Test
	void testShowRooms() {
		TestCase.assertNotNull(roomService.showRooms(1001));
	}

	@Test
	void testAddNewRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setHotelId(6);
		roomBean.setRoomType("Single");
		roomBean.setRoomCapacity(1);
		roomBean.setRoomRent(2000.00);
		roomBean.setRoomStatus("Available");
		TestCase.assertTrue(roomService.addNewRoom(roomBean));
	}

	@Test
	void testDeleteRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(19);
		TestCase.assertTrue(roomService.deleteRoom(roomBean.getRoomId()));
	}

	@Test
	void testUpdateRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(19);
		roomBean.setRoomType("Single");
		roomBean.setRoomCapacity(1);
		roomBean.setRoomRent(2000.00);
		roomBean.setRoomStatus("Booked");
		TestCase.assertTrue(roomService.updateRoom(roomBean));
	}

	@Test
	void testGetRoom() {
		TestCase.assertNotNull(roomService.getRoom(19));
	}

}
