package com.capgemini.exception.first;

import java.io.File;
import java.io.IOException;

public class TestF {

	public static void main(String[] args) throws IOException {

		File f = new File("Uday.txt");
		
		f.createNewFile();
		
	}

}
