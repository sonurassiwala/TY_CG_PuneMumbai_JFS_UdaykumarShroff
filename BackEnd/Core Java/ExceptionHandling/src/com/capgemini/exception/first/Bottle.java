package com.capgemini.exception.first;

import java.io.File;
import java.io.IOException;

public class Bottle {

	void open() throws IOException, ClassNotFoundException { 			//using throws keyword we can give multiple exceptions
		
	File f = new File("Uday.txt");
	
	f.createNewFile();
	
	
	Class.forName("package com.capgemini.exception.first.bottle");
		
	}
	
	
}
