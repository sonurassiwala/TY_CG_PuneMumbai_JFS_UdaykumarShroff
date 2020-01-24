package com.capgemini.hotelmanagement.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefination {
	static {
		System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^the User has loaded the application in the browser$")
	public void the_User_has_loaded_the_application_in_the_browser() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
	}

	@When("^the User clicks on the login Button on navbar$")
	public void the_User_clicks_on_the_login_Button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/section/app-header/nav/div/ul/div/button[1]")).click();
	}

	@When("^the User enters the email in the email textbox$")
	public void the_User_enters_the_email_in_the_email_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("komal@gmail.com");
	}

	@When("^the User enters the  password in the password textbox$")
	public void the_User_enters_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Komal@1234");
	}

	@When("^the User clicks on the login Button$")
	public void the_User_clicks_on_the_login_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
	}

	@Then("^the dashboard pages must be loaded$")
	public void the_dashboard_pages_must_be_loaded() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add Room']")).click();
	}

	
}//End of Class
