package com.capgemini.hotelmanagement.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingStepDefination {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
	}
	WebDriver driver;

	@Given("^the User has loaded the application in the browser$")
	public void the_User_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
	}

	@When("^the User clicks on the login Button on navbar$")
	public void the_User_clicks_on_the_login_Button_on_navbar() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/section/div/div/p/button[1]")).click();
	}

	@When("^the User enters the email in the email textbox$")
	public void the_User_enters_the_email_in_the_email_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("komal@gmail.com");
	}

	@When("^the User enters the password in the password textbox$")
	public void the_User_enters_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Komal@1234");
	}

	@When("^the User clicks on the login Button$")
	public void the_User_clicks_on_the_login_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
	}

	@When("^the User click on hotel-list$")
	public void the_User_click_on_hotel_list() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Hotel List']")).click();
	}

	@When("^the list of hotel appears$")
	public void the_list_of_hotel_appears() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the User click on hotel image$")
	public void the_User_click_on_hotel_image() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotel-list/body/div[2]/div[1]/img")).click();
	}

	@When("^the hotel description opens$")
	public void the_hotel_description_opens() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotel-details/div[1]/img")).click();
	}

	@When("^the room description appears$")
	public void the_room_description_appears() throws Throwable {

	}

	@When("^the user click on book button$")
	public void the_user_click_on_book_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();
	}

	@When("^the booking confirm page appears$")
	public void the_booking_confirm_page_appears() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the User has to select check-in date$")
	public void the_User_has_to_select_check_in_date() throws Throwable {
		driver.findElement(By.name("checkinDate")).sendKeys("");
	}

	@When("^the User has to select check-out date$")
	public void the_User_has_to_select_check_out_date() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"booking\"]/div/div/div/div/form/div[1]/div[1]/div/input")).click();
	}

	@When("^the User click on book button$")
	public void the_User_click_on_book_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"booking\"]/div/div/div/div/form/div[1]/div[2]/div/input")).click();
	}

	@When("^the payment page will display$")
	public void the_payment_page_will_display() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Book Room']")).click();
	}

	@When("^the User enter crad holders name$")
	public void the_User_enter_crad_holders_name() throws Throwable {
		
	}

	@When("^the User enter the cvv$")
	public void the_User_enter_the_cvv() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the User select year$")
	public void the_User_select_year() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the User select month$")
	public void the_User_select_month() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^the User click on confirm payment$")
	public void the_User_click_on_confirm_payment() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^booking confirm page display$")
	public void booking_confirm_page_display() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}//End of class
