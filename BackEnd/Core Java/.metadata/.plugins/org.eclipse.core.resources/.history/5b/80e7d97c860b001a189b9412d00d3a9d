package com.capgemini.junit.junit_jupitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

	private School school;
	
	@BeforeEach
	public void createObject() {
		school = new School();
	}
	
	@Test
	public void testRegisterStudent() {
		Student student = new Student("Uday", 77.52, 'M');
		Student stu = school.registerStudent(student);
		assertEquals(1, stu.getId());
	}

	@Test
	public void testRegisterStudentForNull() {
		assertThrows(NullPointerException.class, () -> school.registerStudent(null));
	}
}
