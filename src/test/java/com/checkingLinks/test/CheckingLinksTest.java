package com.checkingLinks.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckingLinksTest {


	private WebDriver driver;
	private CheckingLinksPage page;
	private String urlPage= "http://demo.guru99.com/test/newtours/";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		page = new CheckingLinksPage(driver);
		
		
		driver.get(urlPage);
	}

	@Test
	public void checkingLinks() {
		
		
		assertTrue(page.checkingPageLink(), "No se encontraron los links");

	}

	@AfterClass
	public void afterClass() {


		driver.quit();
	}

}
