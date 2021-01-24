package com.uploadfile.example;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


 
public class UploadFile {

	private WebDriver driver;
	By seleccionarFileLocator = By.id("file-upload");
	By uploadBtnLocator = By.id("file-submit");
	By fileUploaderLocator = By.id("uploaded-files");
	
	@Before
	public void setUp() throws Exception {


		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/upload");

	}

	@Test
	public void uploadFile() {
		
		if(driver.findElement(seleccionarFileLocator).isDisplayed()) {
			
			File file = new File("C:\\Users\\yerlin022\\Documents\\uploads\\test.txt");
			
			String path = file.getAbsolutePath();
			
			driver.findElement(seleccionarFileLocator).sendKeys(path);
			
			driver.findElement(uploadBtnLocator).click();
			
			assertEquals("test.txt", driver.findElement(fileUploaderLocator).getText());
				
		}else {
			
			System.out.print("Input type file not found");
		}
		
		
	}
	
	

	@After
	public void tearDown() throws Exception {
	}



}
