package com.capgemini.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.HistoryBean;
import com.capgemini.hotelmanagement.beans.HotelResponse;
import com.capgemini.hotelmanagement.beans.RoomBean;
import com.capgemini.hotelmanagement.service.RoomService;

@RestController
//To connect rest with angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {
	@Autowired
	private RoomService roomServices;

	@PostMapping(path = "/bookingRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelResponse userRegistration(@RequestBody BookingInfoBean bookingInfoBean) {
		HotelResponse hotelResponse = new HotelResponse();
		if (roomServices.checkRoomStatus(bookingInfoBean.getRoomId())) {
			boolean isBooked = roomServices.bookHotelRoom(bookingInfoBean);
			if (isBooked) {
				hotelResponse.setStatusCode(201);
				hotelResponse.setMessage("Success");
				hotelResponse.setDescription("Booking Successful.......");
			} else {
				hotelResponse.setStatusCode(401);
				hotelResponse.setMessage("Failed");
				hotelResponse.setDescription("Failed To booked Room........");
			}
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Room is not Availables........");
		}
		return hotelResponse;
	}// userRegistration()

	@GetMapping(path = "/getAvailableRooms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelResponse showRooms(@RequestParam String roomType) {
		List<RoomBean> roomList = roomServices.showAvailableRoom(roomType);
		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setRoomList(roomList);
			hotelResponse.setDescription("Retrieve Available All Rooms.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("There is No Available Rooms........");
		}
		return hotelResponse;
	}// End of showRooms()

	@GetMapping(path = "/getBookedRecords")
	public HotelResponse showBookingDetails(@RequestParam int userId) {
		List<BookingInfoBean> bookingInfoList = roomServices.showBooking(userId);
		HotelResponse hotelResponse = new HotelResponse();
		if (bookingInfoList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setBookingInfoList(bookingInfoList);
			hotelResponse.setDescription("Retrieve All Booking.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("There is No Booked data Available........");
		}
		return hotelResponse;
	}// End of showBookingDetails()

	@DeleteMapping(path = "/cancelBooking")
	public HotelResponse cancelBooking(@RequestParam int bookingId) {
		boolean isCancel = roomServices.cancelBooking(bookingId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isCancel) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Cancel Booking Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable to Cancel Booking........");
		}
		return hotelResponse;
	}// End of deleteBooking()

	@GetMapping(path = "/showHistory")
	public HotelResponse showHistory(@RequestParam int userId) {
		List<HistoryBean> historyList = roomServices.showHistory(userId);
		HotelResponse hotelResponse = new HotelResponse();
		if (historyList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setHistoryList(historyList);
			hotelResponse.setDescription("History Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive History........");
		}
		return hotelResponse;
	}// End of showHistory()

	@GetMapping(path = "/showAllRooms")
	public HotelResponse showAllRooms() {
		List<RoomBean> roomList = roomServices.showAllRooms();
		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setRoomList(roomList);
			hotelResponse.setDescription("Rooms Records Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive Rooms........");
		}
		return hotelResponse;
	}// End of showAllRooms()

	@DeleteMapping(path = "/deleteRoom")
	public HotelResponse deleteRoom(@RequestParam int roomId) {
		boolean isDeletedRoom = roomServices.deleteRoom(roomId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeletedRoom) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Deleted Successfully...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Delete Room...");
		}
		return hotelResponse;
	}// End of deleteRoom()

	@PostMapping(path = "/addRoom")
	public HotelResponse addRoom(@RequestBody RoomBean roomBean) {
		boolean isAdded = roomServices.addNewRoom(roomBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isAdded) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Added Successfully...");

		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Enable to Add Room...");
		}
		return hotelResponse;
	}// End of addRoom()

	@PutMapping(path = "/updateRoom")
	public HotelResponse updateRoom(@RequestBody RoomBean roomBean) {
		boolean isUpdated = roomServices.updateRoom(roomBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Details Updated Successfully.....");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Enable to Update Room Details.....");
		}
		return hotelResponse;
	}// End of updateRoom()

	@GetMapping(path = "/getRoom")
	public HotelResponse getRoom(@RequestParam int roomId) {
		RoomBean roomBean = roomServices.getRoom(roomId);
		HotelResponse hotelResponse = new HotelResponse();
		if (roomBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Room Record Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive Room........");
		}
		return hotelResponse;
	}// End of getRoom()
	
	@GetMapping(path = "/showRooms")
	public HotelResponse showRooms(@RequestParam int hotelId) {
		List<RoomBean> roomList = roomServices.showRooms(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setRoomList(roomList);
			hotelResponse.setDescription("Rooms Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive Room........");
		}
		return hotelResponse;
	}//End of showHistory()
	
	@PostMapping(path = "/getAmount")
	public HotelResponse getBill(@RequestBody BookingInfoBean bookingInfoBean) {
		double totalBill = roomServices.getBill(bookingInfoBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (totalBill > 0.0) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setTotalAmount(totalBill);
			hotelResponse.setDescription("Amount Calculated Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Calculate Total Amount........");
		}
		return hotelResponse;
	}// End of getBill()
	
	@GetMapping(path = "/showAllHistory")
	public HotelResponse showAllHistory() {
		List<HistoryBean> historyList = roomServices.showAllHistory();
		HotelResponse hotelResponse = new HotelResponse();
		if (historyList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setHistoryList(historyList);
			hotelResponse.setDescription("History Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive History........");
		}
		return hotelResponse;
	}//End of showAllHistory()
	
	@GetMapping(path = "/showManagerRooms")
	public HotelResponse showManagerRooms(@RequestParam int hotelId) {
		List<RoomBean> roomList = roomServices.showRooms(hotelId);
		HotelResponse hotelResponse = new HotelResponse();
		if (roomList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setRoomList(roomList);
			hotelResponse.setDescription("Rooms Retrive Successfully.......");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Retrive Rooms........");
		}
		return hotelResponse;
	}//End of showManagerRooms()
	
}// End of Class
