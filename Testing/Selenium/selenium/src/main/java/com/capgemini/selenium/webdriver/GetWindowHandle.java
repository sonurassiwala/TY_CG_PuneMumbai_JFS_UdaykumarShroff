package com.capgemini.selenium.webdriver;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandle {

	static {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	}
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		String wh = driver.getWindowHandle();
		System.out.println(wh);
		
		driver.get("https://naukri.com");
		Set<String> whs = driver.getWindowHandles();
		System.out.println("Number of Windows : "+whs.size());
		System.out.println(whs);
		driver.quit();
		
		
	}

}
