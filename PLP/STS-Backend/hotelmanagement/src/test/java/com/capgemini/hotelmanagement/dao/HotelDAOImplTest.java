package com.capgemini.hotelmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.hotelmanagement.beans.HotelBean;

import junit.framework.TestCase;

@SpringBootTest
class HotelDAOImplTest {

	@Autowired
	private HotelDAO hotelDAO;

	@Test
	void testShowAllHotels() {
		TestCase.assertNotNull(hotelDAO.showAllHotels());
	}

	@Test
	void testUpdateHotelDetails() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(1);
		hotelBean.setHotelName("Taj");
		hotelBean.setLocation("Mumbai");
		TestCase.assertTrue(hotelDAO.updateHotelDetails(hotelBean));
	}

	@Test
	void testSearchHotelDetails() {
		TestCase.assertEquals(true, !hotelDAO.searchHotelDetails("Mumbai").isEmpty());
	}

	@Test
	void testGetHotelDetails() {
		TestCase.assertNotNull(hotelDAO.getHotelDetails(1));
	}

	@Test
	void testAddHotelDetails() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelName("Oberoi");
		hotelBean.setLocation("Mumbai");
		TestCase.assertTrue(hotelDAO.addHotelDetails(hotelBean));
	}

	@Test
	void testDeleteHotelDetails() {
		TestCase.assertTrue(hotelDAO.deleteHotelDetails(5));
	}

}
