package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{


	By registerLinkLocater = By.linkText("REGISTER");
	By registerPageLocater = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocater = By.id("email");
	By passwordLocater = By.name("password");
	By confirmPasswordLocater = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocater = By.name("submit");
	By font =              By.tagName("font");



	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public void registerCase() throws InterruptedException {

		click(registerLinkLocater);
		Thread.sleep(2000);

		if(isDisplayed(registerPageLocater)) {


			type(userNameLocater, "Automation");
			type(passwordLocater, "Prueba1");
			type(confirmPasswordLocater, "Prueba1");

			click(registerBtnLocater);


			List<WebElement> fonts = findElements(font);


			assertEquals("Note: Your user name is Automation.", fonts.get(5).getText());


		}else {

			System.out.print("Register pages was not found!");
		}



	}

}
