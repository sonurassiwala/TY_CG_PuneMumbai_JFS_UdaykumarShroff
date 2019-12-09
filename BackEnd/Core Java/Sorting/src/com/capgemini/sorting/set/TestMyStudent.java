package com.capgemini.sorting.set;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMyStudent {

	

		private static final Scanner scan = new Scanner(System.in);
		static ArrayList<MyStudent> al = new ArrayList<MyStudent>();
		
		static void addStudent() {
			System.out.println("Enter name : ");
			scan.next();
			String name = scan.nextLine();
			System.out.println("Enter id : ");
			int id = scan.nextInt();
			System.out.println("Enter percentage : ");
			double percentage = scan.nextDouble();
			
			MyStudent m1 = new MyStudent(id, name, percentage);
			al.add(m1);
			
		}
		
		static void displayStudent() {
			
			for(MyStudent myStudent : al) {
				
				MyStudent m = myStudent;
				System.out.println("name : "+m.name);
				System.out.println("id : "+m.id);
				System.out.println("percentage : "+m.percentage);
				System.out.println("-----------------------------");
				
			}
		}
		
		public static void main(String[] args) {
		
		while(true) {
			System.out.println("Enter option : ");
			//int choice = 
		}
		
		
	}

}
