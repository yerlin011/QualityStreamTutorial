package com.screenshot.example;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

	private WebDriver driver;

	By nameLocater = By.name("q");

	
	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}


	public String getDate() {

		DateFormat format = new SimpleDateFormat("DD-MM-yyyy");

		Date date = new Date();

		return format.format(date);
	}

	@Rule
	public TestRule watcher = new TestWatcher() {
		
		@Override
		protected void failed(Throwable throwable, Description description ) {

			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshotFile, new File("Error_"+description.getMethodName()+"-"+getDate()+".png"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}	
		
		@Override
		protected void finished(Description description) {
			
			driver.quit();
		}
		
	};





		@Test
		public void GoogleSearchtest() {

			WebElement searchBox = driver.findElement(nameLocater);

			searchBox.sendKeys("Quality-Stream Tutorial introduccion a la automatizacion de pruebas de software");
			searchBox.submit();

			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

			assertEquals("Esto ocasionara un error", driver.getTitle());


		}

	}
