package com.capgemini.hotelmanagement.dao;

import java.util.List;

import com.capgemini.hotelmanagement.beans.HotelBean;
import com.capgemini.hotelmanagement.beans.RoomBean;

public interface HotelDAO {

	public List<HotelBean> showAllHotels();

	public boolean updateHotelDetails(HotelBean hotelBean);

	public List<HotelBean> searchHotelDetails(String location);

	public HotelBean getHotelDetails(int hotelId);

	public boolean addHotelDetails(HotelBean hotelBean);

	public boolean deleteHotelDetails(int hotelId);
	
	public HotelBean seeManagerHotel(int userId);
	
	public List<RoomBean> seeHotelRooms(int hotelId);

}// End of interface
