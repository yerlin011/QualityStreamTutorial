package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursTestLocators{


	private WebDriver driver;
	
	By registerLinkLocater = By.linkText("REGISTER");
	By registerPageLocater = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocater = By.id("email");
	By passwordLocater = By.name("password");
	By confirmPasswordLocater = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocater = By.name("submit");
	
	By userLocater = By.name("userName");
	By passLocater = By.name("password");
	
	By signInBtnLocater = By.name("submit");
	By loginSuccessLocater = By.tagName("h3");
	
	 
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		

	    driver.get("http://demo.guru99.com/test/newtours/");
		
	}
	
	
	@Test
	public void RegisterUser() throws InterruptedException {
		
	
			 
			driver.findElement(registerLinkLocater).click();
			Thread.sleep(2000);
			
			 if(driver.findElement(registerPageLocater).isDisplayed()) {
				 
				 driver.findElement(userNameLocater).sendKeys("Automation");
				 driver.findElement(passwordLocater).sendKeys("Prueba1");
				 driver.findElement(confirmPasswordLocater).sendKeys("Prueba1");
				 
				 
				 driver.findElement(registerBtnLocater).click();
				 
				 List<WebElement> fonts = driver.findElements(By.tagName("font"));
				 
				 assertEquals("Note: Your user name is Automation.", fonts.get(5).getText());
				 
			 }else {
				 
				 System.out.print("Register pages was not found!");
			 }

	}
	
	@Test
	public void signIn() throws InterruptedException {
		
		if(driver.findElement(userLocater).isDisplayed()) {
			
			
			driver.findElement(userLocater).sendKeys("Automation");
			driver.findElement(passLocater).sendKeys("Prueba1");
			
			driver.findElement(signInBtnLocater).click();
			
			
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(loginSuccessLocater).isDisplayed());


			
			
		}else {
			
			System.out.print("Texbox was not found");
		}
		
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}


	
}
