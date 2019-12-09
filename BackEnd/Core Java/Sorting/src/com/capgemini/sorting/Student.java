package com.capgemini.sorting;

public class Student implements Comparable<Student>{

	int id;
	String name;
	double percentage;
	
	public Student(int id, String name, double percentage) {
		this.id = id;
		this.name = name;
		this.percentage = percentage;
	}

	@Override
	public int compareTo(Student s4) {

		Double k = this.percentage;
		Double t = s4.percentage;
		
		return k.compareTo(t);
	}

	//Logic to sort Students by ID
	/*@Override
	 * public int compareTo(Student s) { //override compareTo method of comparable interface
	 * 
	 * if(this.id > s.percentage) { return 1; }
	 * 
	 * else if(this.id < s.percentage) { return -1; }
	 * 
	 * else { return 0; } }
	 */
	
	//Logic to sort Students by Percentage
	/*
	 * @Override 
	 * public int compareTo(Student s1) {
	 * 
	 * if(this.percentage > s1.percentage) { return 1; }
	 * 
	 * else if(this.percentage < s1.percentage) { return -1; }
	 * 
	 * else { return 0; } }
	 */
	
	
	
	/*//Logic to compare by Name
	@Override
	public int compareTo(Student s2) {

		
		 * String k = this.name; 
		 * String t = s2.name;
		 * 
		 * int res = k.compareTo(t);
		 * 
		 * return res;
		 
		
		return this.name.compareTo(s2.name);
		//return this.name.compareTo(s2.name) * -1;   //sorting in descending order by *-1
	*/
	}

