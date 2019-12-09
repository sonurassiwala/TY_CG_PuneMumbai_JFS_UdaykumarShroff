package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.beans.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;

public class GetInfo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDAO dao = UserFactory.getInstance();
		System.out.println("Enter UserId : ");
		UserBean user = dao.getInfo(sc.nextInt());
		if(user != null) {
			System.out.println(user);
		}
		else {
			System.out.println("Something went wrong .....");
		}
		sc.close();
	}

}
