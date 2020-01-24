package com.capgemini.hotelmanagement.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RegisterStepDefination {
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
	
	@When("^the User click on register Button on Navbar$")
	public void the_User_click_on_register_Button_on_Navbar() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
	}

	@When("^the User enter the userName in the userName textbox$")
	public void the_User_enter_the_userName_in_the_userName_textbox() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Mayur Bokad");
	}

	@When("^the User enter the email in the email textbox$")
	public void the_User_enter_the_email_in_the_email_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("mayur@gmail.com");
	}

	@When("^the User enter the password in the password textbox$")
	public void the_User_enter_the_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Mayur@1234");
	}

	@When("^the User enters the phoneNumber in the phoneNumber textbox$")
	public void the_User_enters_the_phoneNumber_in_the_phoneNumber_textbox() throws Throwable {
		driver.findElement(By.name("phoneNumber")).sendKeys("9856231478");
	}

	@When("^User selects the gender in the radio$")
	public void user_selects_the_gender_in_the_radio() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"Male\"]"));
	    
	}

	@When("^the User selects the nationality in the role dropdown$")
	public void the_User_selects_the_nationality_in_the_role_dropdown() throws Throwable {
		WebElement listBox= driver.findElement(By.name(""));
		Select select=new Select(listBox);
		select.selectByVisibleText("User");
	}

	@When("^the User clicks on the register Button$")
	public void the_User_clicks_on_the_register_Button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
	}

	@Then("^the board pages must be loaded$")
	public void the_board_pages_must_be_loaded() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/section/app-header/nav/div/ul/div/button[1]")).click();
	}
}
