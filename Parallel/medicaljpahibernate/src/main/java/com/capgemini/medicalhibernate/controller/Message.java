package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.MessageDAO;
import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.MessageBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class Message {

	MessageDAO messageDAO = MedicalFactory.getMessage();
	Validation val = MedicalFactory.getValidate();
	Scanner sc = new Scanner(System.in);

	UserDAO userDAO = MedicalFactory.getUser();

	int choice;

	public void usermessage(UserBean userBean) {
		System.out.println("Enter your choice :");
		System.out.println("Press 1 to send message");
		System.out.println("Press 2 to view response");
		choice = Integer.parseInt(sc.nextLine());
		int uId = userBean.getUserId();
		switch (choice) {
		case 1:
			System.out.println("Enter the message to be send : ");
			String message = sc.nextLine();
			String type = "question";
			messageDAO.sendMessage(uId, message, type);
			break;
		case 2:
			messageDAO.getResponse(userBean.getUserId());
			break;
		default:
			System.out.println("Enter the correct choice!!!");
			break;

		}

	}

	public void adminmessage(UserBean userBean) {
		System.out.println("Enter your choice :");
		System.out.println("Press 1 to view messages");
		System.out.println("Press 2 to send response");
		choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1:
			messageDAO.getMessage(userBean.getUserId());
			break;
		case 2:
			while (true) {
				System.out.println("Enter the user id : ");
				String uid = sc.nextLine();
				if (val.idValidation(uid)) {

					System.out.println("Enter the response message : ");
					String message = sc.nextLine();

					String type = "answer";
					messageDAO.sendResponse(Integer.parseInt(uid), message, type);

				}
				break;
			}
		default:
			System.out.println("Enter the correct choice!!!");
			break;
		}
	}

}
