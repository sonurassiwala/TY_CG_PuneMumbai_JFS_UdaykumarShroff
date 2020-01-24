package com.capgemini.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.HotelBean;
import com.capgemini.hotelmanagement.beans.HotelResponse;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.exception.HotelNotFoundException;
import com.capgemini.hotelmanagement.service.HotelService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping(path = "/showAllHotels")
	public HotelResponse showAllHotels() {
		List<HotelBean> hotelList = hotelService.showAllHotels();
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelList != null && !hotelList.isEmpty()) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotels Record Found...");
			hotelResponse.setHotelList(hotelList);
		} else {
			throw new HotelNotFoundException();
		}
		return hotelResponse;
	}

	@GetMapping(path = "/getHotelDetails")
	public HotelResponse getHotelDetails(int hotelId) {
		HotelBean hotelBean = hotelService.getHotelDetails(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Record Found");
			hotelResponse.setHotelBean(hotelBean);
		} else {
			throw new HotelNotFoundException();
		}
		return hotelResponse;
	}

	@PostMapping(path = "/addHotel")
	public HotelResponse addHotel(@RequestBody HotelBean hotelBean) {
		boolean isAdded = hotelService.addHotelDetails(hotelBean);

		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Added Successfully...");

		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Enable to Add Hotel...");
		}
		return hotelResponse;
	}

	@PutMapping(path = "/updateHotelDetails")
	public HotelResponse updateHotelDetails(@RequestBody HotelBean hotelBean) {
		boolean isUpdated = hotelService.updateHotelDetails(hotelBean);

		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Updated Successfully.....");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Enable to Update Hotel.....");
		}
		return hotelResponse;
	}

	@DeleteMapping(path = "/deleteHotel")
	public HotelResponse deleteHotel(int hotelId) {

		boolean isDeleted = hotelService.deleteHotelDetails(hotelId);
		HotelResponse hotelResponse = new HotelResponse();

		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Record Deleted.....");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Enable to Delete Hotel Record.....");
		}
		return hotelResponse;
	}

	@GetMapping(path = "/searchHotel")
	public HotelResponse searchHotel(String location) {
		List<HotelBean> searchList = hotelService.searchHotelDetails(location);

		HotelResponse hotelResponse = new HotelResponse();
		if (searchList != null && !searchList.isEmpty()) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Record found.....");
			hotelResponse.setHotelList(searchList);
		} else {
			throw new HotelNotFoundException();
		}
		return hotelResponse;
	}
	
	
	@GetMapping(path = "/seeManagerHotel")
	public HotelResponse seeManagerHotel(@RequestParam int userId) {
		HotelBean hotelBean = hotelService.seeManagerHotel(userId);
		
		HotelResponse hotelResponse = new HotelResponse();
		if (hotelBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Hotel Record found.....");
			hotelResponse.setHotelBean(hotelBean);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("No Hotel Records Found.....");
		}
		
		return hotelResponse;
	}
	

	@GetMapping(path = "/seeManagerHotelRooms")
	public HotelResponse seeManagerHotelRooms(@RequestParam int hotelId) {
		List<RoomBean> roomList = hotelService.seeHotelRooms(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Record found.....");
			hotelResponse.setRoomList(roomList);
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room Records Found.....");
		}
		return hotelResponse;
	}
}
