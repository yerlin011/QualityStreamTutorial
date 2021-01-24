package com.qualitystream.code.examples;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckDownloadFile {
	
  private WebDriver driver;
  
  
  @BeforeClass
  public void beforeClass() {
	  
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/download");


  }
  
  @Test
  public void checkDownloadFile() throws MalformedURLException, IOException {
	  
	  String link = driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).getAttribute("href");
	  
	  HttpURLConnection httpUrlConnection = (HttpURLConnection)(new URL(link)).openConnection();
	  
	  httpUrlConnection.setRequestMethod("HEAD");
	  httpUrlConnection.connect();
	  
	  String contentType = httpUrlConnection.getContentType();
	  int contentLength = httpUrlConnection.getContentLength();
	  
	  System.out.println(contentType);
	  System.out.println(contentLength);

	  
	  assertEquals(contentType, "application/octet-stream");
	  assertNotEquals(contentLength,0);
  }

  @AfterClass
  public void afterClass() {
  }

}
