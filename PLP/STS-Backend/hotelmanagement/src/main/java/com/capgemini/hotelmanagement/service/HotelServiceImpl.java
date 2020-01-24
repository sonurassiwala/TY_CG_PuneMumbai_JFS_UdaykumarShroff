package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.HotelBean;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.dao.HotelDAO;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public List<HotelBean> showAllHotels() {
		return hotelDAO.showAllHotels();
	}

	@Override
	public boolean updateHotelDetails(HotelBean hotelBean) {
		return hotelDAO.updateHotelDetails(hotelBean);
	}

	@Override
	public List<HotelBean> searchHotelDetails(String location) {
		return hotelDAO.searchHotelDetails(location);
	}

	@Override
	public HotelBean getHotelDetails(int hotelId) {
		return hotelDAO.getHotelDetails(hotelId);
	}

	@Override
	public boolean addHotelDetails(HotelBean hotelBean) {
		return hotelDAO.addHotelDetails(hotelBean);
	}

	@Override
	public boolean deleteHotelDetails(int hotelId) {
		return hotelDAO.deleteHotelDetails(hotelId);
	}

	@Override
	public HotelBean seeManagerHotel(int userId) {
		return hotelDAO.seeManagerHotel(userId);
	}

	@Override
	public List<RoomBean> seeHotelRooms(int hotelId) {
		return hotelDAO.seeHotelRooms(hotelId);
	}

}
