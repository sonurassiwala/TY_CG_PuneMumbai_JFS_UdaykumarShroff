package com.capgemini.hotelmanagement.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.hotelmanagement.beans.HotelBean;

import junit.framework.TestCase;

@SpringBootTest
class HotelServiceImplTest {

	@Autowired
	private HotelService hotelService;

	@Test
	void testShowAllHotels() {
		TestCase.assertNotNull(hotelService.showAllHotels());
	}

	@Test
	void testUpdateHotelDetails() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(1);
		hotelBean.setHotelName("Taj");
		hotelBean.setLocation("Mumbai");
		TestCase.assertTrue(hotelService.updateHotelDetails(hotelBean));
	}

	@Test
	void testSearchHotelDetails() {
		TestCase.assertEquals(true, !hotelService.searchHotelDetails("Mumbai").isEmpty());
	}

	@Test
	void testGetHotelDetails() {
		TestCase.assertNotNull(hotelService.getHotelDetails(1));
	}

	@Test
	void testAddHotelDetails() {
	HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelName("Oberoi");
		hotelBean.setLocation("Mumbai");
		TestCase.assertTrue(hotelService.addHotelDetails(hotelBean));
	}

	@Test
	void testDeleteHotelDetails() {
		TestCase.assertTrue(hotelService.deleteHotelDetails(5));
	}

}
