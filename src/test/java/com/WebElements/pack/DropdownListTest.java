package com.WebElements.pack;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DropdownListTest {
	
	private WebDriver driver;
	
	private DropdownListPage pageDDL;

	@Before
	public void setUp() throws Exception {
		
		
		pageDDL = new DropdownListPage(driver);
		pageDDL.ChromeDriverConnection();
		pageDDL.visit("http://demo.guru99.com/test/newtours/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		
		pageDDL.signInCase();  
		
        assertTrue(pageDDL.dropDownListPassengers().equalsIgnoreCase("4"));
        assertTrue(pageDDL.dropDownListDeparting().equalsIgnoreCase("Paris"));
		
		
		
	}

}
