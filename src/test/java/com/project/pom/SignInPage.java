package com.project.pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	
	
	By userLocater = By.name("userName");
	By passLocater = By.name("password");
	
	By signInBtnLocater = By.name("submit");
	By loginSuccessLocater = By.tagName("h3");
	

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void signInCase() throws InterruptedException {
		
		
		if(isDisplayed(userLocater)) {
			
			
			type(userLocater,"Automation");
			type(passLocater,"Prueba1");
			
			click(signInBtnLocater);
			
			Thread.sleep(2000);

			assertTrue(isDisplayed(loginSuccessLocater));
			
		}else {
			
			System.out.print("Texbox was not found");
		}
		
		
		
	}

}
