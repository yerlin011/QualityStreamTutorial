package com.qualitystream.code.examples;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFile {

	private WebDriver driver;
	private String downLoadedFilePath = "C:\\Users\\yerlin022\\test";
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		HashMap<String,Object> chromePref = new HashMap<String,Object>();
		
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("download.default_directory", downLoadedFilePath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",chromePref);
		
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
	}

	@Test
	public void downLoadFile() throws InterruptedException {
		
		if(driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).isDisplayed()){
			
			
			driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();
			
			Thread.sleep(2000);
			
			File  folder = new File(downLoadedFilePath);
			File[] listOfFiles = folder.listFiles();
			
			assertTrue(listOfFiles.length>0,"File not downloaded correctly");
			
		}
		
	}

	@AfterClass
	public void afterClass() {
	}

}
