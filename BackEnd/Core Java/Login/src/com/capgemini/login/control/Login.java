package com.capgemini.login.control;

import java.util.Scanner;

import com.capgemini.login.beans.LoginUserBean;
import com.capgemini.login.dao.LoginUserDAO;
import com.capgemini.login.factory.LoginUserFactory;

public class Login {
     
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LoginUserDAO dao = LoginUserFactory.getInstance();
		System.out.println("Enter UserId : ");
		int userid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		
		LoginUserBean user = dao.userLogin(userid, password);
		
		if(user != null) {
			
			System.out.println(user);
			
		}
		else {
			System.out.println("Something went wrong .....");
		}
		sc.close();
}
}