package com.capgemini.medicalcollection.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.medicalcollection.bean.MessageBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.MessageDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;

public class MessageController {
	Scanner scan = new Scanner(System.in);
	int choice;
	MessageDAO dao = MedicineFactory.getMessageDAO();

	public void userMessage(UserBean userBean) {
		System.out.println("Press 1 to send message");
		System.out.println("Press 2 to view response");

		choice = Integer.parseInt(scan.nextLine());
		int uId = userBean.getUserId();
		switch (choice) {

		case 1:
			String type = "Question";

			System.out.println("Enter message to be send");
			String message = scan.nextLine();
			boolean isSend = dao.sendMessage(message, uId, type);
			if (isSend) {
				System.out.println("Message sent..");
			} else {
				System.out.println("Something went wrong..");
			}

			break;
		case 2:

			MessageBean bean = dao.viewResponse(uId);
			break;

		default:
			break;
		}
		new UserIndex().userIndex(userBean);
	}

	public void adminMessage(UserBean userBean) {
		System.out.println("Enter your choice");
		System.out.println("Press 1 to view messages");
		System.out.println("Press 2 to send response");

		choice = scan.nextInt();
		switch (choice) {
		case 1:
			MessageBean bean = dao.viewMessage();
			break;
		case 2:
			String type = "Response";
			System.out.println("Enter response to be send");
			String message = scan.next();
			System.out.println("Enter user Id");
			int uId = scan.nextInt();
			boolean rs = dao.sendResponse(message, type, uId);
			if (rs = true) {
				System.out.println("Response sent successfully..");
			} else {
				System.out.println("Something wents wrong..");
			}
			break;

		default:
			break;
		}
		new AdminIndex().adminIndex(userBean);

	}

}
