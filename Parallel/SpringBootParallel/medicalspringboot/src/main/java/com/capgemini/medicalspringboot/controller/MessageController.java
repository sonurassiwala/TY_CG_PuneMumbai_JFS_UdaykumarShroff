package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.MessageBean;
import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.service.MessageService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {

	@Autowired
	private MessageService service;
	
	@GetMapping(path = "/getMessage",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean showAdminMessage() {
		List<MessageBean> messageBean = service.getMessage();
		ResponseBean response = new ResponseBean();
		if (messageBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Feedback get.......");
			response.setMessageList(messageBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User feedback didn't get........");
		}
		return response;
	}//End of getAdminMessage()
	
	@GetMapping(path = "/getResponse", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean showUserMessage(@RequestParam int userId) {
		List<MessageBean> messageBeans= service.getResponse(userId);
		ResponseBean response=new ResponseBean();
		if (messageBeans!=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessageList(messageBeans);
			response.setDescription("Response get from Admin.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Didn't get any response........");
		}
		return response;
	}//End of getUserMessage()
	
	@PutMapping(path = "/sendMessage",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean adminResponse(@RequestParam int userId, @RequestParam String message, @RequestParam String type) {
		boolean isSent = service.sendMessage(userId, message, type);
		ResponseBean response=new ResponseBean();
		if (isSent) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Feedback sent to User.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Feedback didn't sent to User........");
		}
		return response;
	}//End of adminResponse()
	
	@PutMapping(path = "/sendResponse")
	public ResponseBean userResponse(@RequestParam int userId,@RequestParam String message,@RequestParam String type) {
		boolean isSent = service.sendResponse(userId, message, type);
		ResponseBean response=new ResponseBean();
		if (isSent) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Response sent to user.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Response didn't sent to user.........");
		}
		return response;
	}//End of userResponse()
	
	
}
