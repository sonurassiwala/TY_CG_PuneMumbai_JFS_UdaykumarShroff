package com.capgemini.hotelmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.HotelResponse;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.EmailAlreadyExistException;
import com.capgemini.hotelmanagement.exception.EmailNotExistException;
import com.capgemini.hotelmanagement.exception.IncorrectPasswordException;
import com.capgemini.hotelmanagement.exception.InvalidCredentialsException;
import com.capgemini.hotelmanagement.exception.PasswordException;
import com.capgemini.hotelmanagement.exception.UserNotFoundException;
import com.capgemini.hotelmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelResponse userRegistration(@Valid @RequestBody UserBean userBean) {
		HotelResponse hotelResponse = new HotelResponse();
		String email = userBean.getEmail();
		boolean isEmailPresent = userService.emailPresent(email);
		if (!isEmailPresent) {
			boolean registerUser = userService.userRegistration(userBean);

			if (registerUser) {
				hotelResponse.setStatusCode(201);
				hotelResponse.setMessage("Success");
				hotelResponse.setDescription("Registered Successfully.......");
			} else {
				throw new EmailAlreadyExistException();
			}
			return hotelResponse;
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Email Already Exist.......");
			return hotelResponse;
		}
	}// userRegistration()

	@PostMapping(path = "/userLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelResponse UsersLogin(@Valid @RequestParam("email") String email,
			@Valid @RequestParam("password") String password) {
		// if (userService.passwordPresent(email, password)) {
		HotelResponse hotelResponse = new HotelResponse();
		if (userService.emailPresent(email)) {
			if (userService.passwordChecker(email, password)) {
				UserBean userLogin = userService.userLogin(email, password);
				if (userLogin != null) {
					hotelResponse.setStatusCode(201);
					hotelResponse.setMessage("Success");
					hotelResponse.setUserBean(userLogin);
					hotelResponse.setDescription("Users Logged in........");
					return hotelResponse;
				} else {
					throw new InvalidCredentialsException();
				}
			} else {
				throw new IncorrectPasswordException();
			}
		} else {
			throw new EmailNotExistException();
		}

		// }
	}// End of UserLogin()

	@PostMapping(path = "/updatePassword")
	public HotelResponse passwordUpdate(@Valid @RequestParam("email") String email,
			@Valid @RequestParam("phoneNumber") String phoneNumber, @Valid @RequestParam("password") String password) {
		boolean isUpdated = userService.resetPassword(email, phoneNumber, password);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Password Updated Successfully...");
		} else {
			throw new PasswordException();
		}
		return hotelResponse;
	}// End of passwordUpdate()

	@PostMapping(path = "/updateProfile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelResponse updateProfile(@Valid @RequestBody UserBean userBean) {
		boolean isUpdated = userService.updateProfile(userBean);
		HotelResponse hotelResponse = new HotelResponse();
		if (isUpdated) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Profile Updated Successfully...");
		} else {
			hotelResponse.setStatusCode(401);
			hotelResponse.setMessage("Failed");
			hotelResponse.setDescription("Unable To Update Profile...");
		}
		return hotelResponse;
	}// End of updateProfile()

	@GetMapping(path = "/showProfile")
	public HotelResponse showProfile(@Valid @RequestParam int userId) {
		UserBean userBean = userService.showProfile(userId);
		HotelResponse hotelResponse = new HotelResponse();
		if (userBean != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setUserBean(userBean);
			hotelResponse.setDescription("Profile Retrived Successfully...");
		} else {
			throw new UserNotFoundException();
		}

		return hotelResponse;
	}// End of showProfile()
	
	@GetMapping(path = "/showAllUsers")
	public HotelResponse showAllUsers() {
		List<UserBean> userList = userService.showUser();
		HotelResponse hotelResponse = new HotelResponse();
		if (userList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setUserList(userList);
			hotelResponse.setDescription("User List Retrived Successfully...");
			return hotelResponse;
		} else {
			throw new UserNotFoundException();
		}
	}// End of showAllUsers()
	
	@GetMapping(path = "/showAllManagers")
	public HotelResponse showAllManagers() {
		List<UserBean> userList = userService.showManager();
		HotelResponse hotelResponse = new HotelResponse();
		if (userList != null) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setUserList(userList);
			hotelResponse.setDescription("Manager List Retrived Successfully...");
			return hotelResponse;
		} else {
			throw new UserNotFoundException();
		}
	}// End of showAllUsers()\
	
	@DeleteMapping(path = "/deleteUser")
	public HotelResponse removeUser(@RequestParam int userId) {
		boolean isDeleted = userService.removeUser(userId);
		HotelResponse hotelResponse = new HotelResponse();
		if (isDeleted) {
			hotelResponse.setStatusCode(201);
			hotelResponse.setMessage("Success");
			hotelResponse.setDescription("Deleted Successfully...");
			return hotelResponse;
		} else {
			throw new UserNotFoundException();
		}
	}
}// End of Class
