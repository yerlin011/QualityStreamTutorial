package com.WebElements.pack;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownListPage extends Base{


	By flightsLinkLocater  = By.linkText("Flights");
	By passCountLocater = By.name("passCount");
	By fromPortLocater = By.name("fromPort");
	By option         = By.tagName("option");
	
	
	///
	
	By userLocater = By.name("userName");
	By passLocater = By.name("password");
	
	By signInBtnLocater = By.name("submit");
	By loginSuccessLocater = By.tagName("h3");
	


	public DropdownListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String dropDownListPassengers() throws InterruptedException {
		
		String textpassengers = "";
		
		if(isDisplayed(flightsLinkLocater)) {
			
			
			
			click(flightsLinkLocater);
			
			Thread.sleep(3000);
			
			WebElement elementDropDownList = findElement(passCountLocater);

			List<WebElement> options = elementDropDownList.findElements(option);


			for (int i = 0; i < options.size(); i++) {
				
				System.out.print(options.get(i));

				if(getText(options.get(i)).equals("4 ")) {


					click(options.get(i));


				}

			}


			

			for (int i = 0; i < options.size(); i++) {

				if(options.get(i).isSelected()) {


					textpassengers = getText(options.get(i));

				}


			}

			
		}


		return textpassengers;
	}


	public String dropDownListDeparting() {

		Select selectList = new Select(findElement(fromPortLocater));
		
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
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
