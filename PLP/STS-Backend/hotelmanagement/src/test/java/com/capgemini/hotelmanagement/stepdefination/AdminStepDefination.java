package com.capgemini.hotelmanagement.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefination {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
	}

	WebDriver driver;
	
	@Given("^the Admin has loaded the application in the browser$")
	public void the_Admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
	}

	@When("^the Admin clicks on the login Button on navbar$")
	public void the_Admin_clicks_on_the_login_Button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/section/app-header/nav/div/ul/div/button[1]")).click();
	}

	@When("^the Admin enters the email in the email textbox$")
	public void the_Admin_enters_the_email_in_the_email_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("diksha@gmail.com");
	}

	@When("^the Admin enters the  password in the password textbox$")
	public void the_Admin_enters_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Diksha@1234");
	}

	@When("^the Admin clicks on the login Button$")
	public void the_Admin_clicks_on_the_login_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
	}

	@Then("^the again dashboard pages must be loaded$")
	public void the_again_dashboard_pages_must_be_loaded() throws Throwable {
	//	driver.findElement(By.xpath("//*[@id=\"collapsibleNavId\"]/ul[1]/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-front-page/section/app-navbar/nav/div/div[2]/ul[1]/li[3]/a")).click();
	}
	
//	@When("^Admin Clicks on hotel$")
//	public void admin_Clicks_on_hotel() throws Throwable {
//		driver.findElement(By.xpath("//*[@id=\"collapsibleNavId\"]/ul[1]/li[3]/a")).click();
//	}

	@Then("^Admin enters hotel name$")
	public void admin_enters_hotel_name() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Rudra");
	}

	@Then("^Admin enters location$")
	public void admin_enters_location() throws Throwable {
		driver.findElement(By.name("location")).sendKeys("Pune");
	}

	@Then("^Admin enters image url$")
	public void admin_enters_image_url() throws Throwable {
		driver.findElement(By.name("imgURL")).sendKeys("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
	}

	@Then("^Admin enters add hotel$")
	public void admin_enters_add_hotel() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/button")).click();
//		driver.findElement(By.xpath("//a[text()=' Add Hotel ']")).click();
	}

}//End of class
