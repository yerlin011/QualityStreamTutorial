package com.qualitystream.tutorial;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class GoogleSearchTest {
	
	
	
private WebDriver driver;
By videoLocater = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");

	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		                                              
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
			
	}
	
	
	@Test
	public void testGooglePage(){
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.clear();
		
		searchBox.sendKeys("Quality-Stream Tutorial introduccion a la automatizacion de pruebas de software");
		
		searchBox.submit();
		
		/*Implicity wait
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
		
		/*
		Explicity wait
		
		WebDriverWait ewait = new WebDriverWait(driver,10);
		
		ewait.until(ExpectedConditions.titleContains("Quality-Stream"));
		
		assertEquals("Quality-Stream Tutorial introduccion a la automatizacion de pruebas de software - Buscar con Google", driver.getTitle());
		*/
		
		//Fluent wait
		
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).
				withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		
		WebElement video = fWait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				
				
				return driver.findElement(videoLocater);
			}
			
			
			
		});
		
		assertTrue(driver.findElement(videoLocater).isDisplayed());
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
