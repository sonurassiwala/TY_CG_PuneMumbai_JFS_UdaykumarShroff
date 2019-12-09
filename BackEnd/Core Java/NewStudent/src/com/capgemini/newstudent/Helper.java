package com.capgemini.newstudent;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Helper {
	
	void displayPass(ArrayList<Student> al) {
		
		List<Student> li = al.stream().filter(i -> i.percentage > 35).collect(Collectors.toList());
		Iterator<Student> it = li.iterator();
		while(it.hasNext()){
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			System.out.println("Gender : "+s.gender);
			System.out.println("--------------------------------");
		}
		
	}
	
	void displayPassGender(ArrayList<Student> al, char g) {
		
		List<Student> li = al.stream().filter(i -> (i.percentage > 35 && i.gender == g)).collect(Collectors.toList());
		Iterator<Student> it = li.iterator();
		while(it.hasNext()){
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			System.out.println("Gender : "+s.gender);
			System.out.println("--------------------------------");
		}
		
	}
	
	
	void displayFail(ArrayList<Student> al) {
		
		List<Student> li = al.stream().filter(i -> i.percentage < 35).collect(Collectors.toList());
		Iterator<Student> it = li.iterator();
		while(it.hasNext()){
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			System.out.println("Gender : "+s.gender);
			System.out.println("--------------------------------");
		}
		
	}
	
	void displayFailGender(ArrayList<Student> al, char g) {
		
		List<Student> li = al.stream().filter(i -> (i.percentage < 35 && i.gender == g)).collect(Collectors.toList());
		Iterator<Student> it = li.iterator();
		while(it.hasNext()){
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			System.out.println("Gender : "+s.gender);
			System.out.println("--------------------------------");
		}
		
	}
	
	Comparator<Student> comp = (s1,s2) ->{
		
		Double i = s1.percentage;
		Double j = s2.percentage;
		
		 return i.compareTo(j);
		
	};
	
	void topper(ArrayList<Student> al) {
		Student small = al.stream().max(comp).get();
		System.out.println("Topper : "+small.name);
	}
	
	void minMarks(ArrayList<Student> al) {
		Student small = al.stream().min(comp).get();
		System.out.println("***Topper***");
		System.out.println("Name : "+small.name);
		System.out.println("Id : "+small.id);
		System.out.println("Percentage : "+small.percentage);
		System.out.println("Gender : "+small.gender);
	}
	
	

	void displayAll(ArrayList<Student> al) {
		
		Iterator<Student> it = al.iterator();
		while(it.hasNext()){
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			System.out.println("Gender : "+s.gender);
			System.out.println("--------------------------------");
		}
		
	}

}
