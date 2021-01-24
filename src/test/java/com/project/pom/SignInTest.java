package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInTest {

	private WebDriver driver;
	
	private SignInPage signIn;

	@Before
	public void setUp() throws Exception {
		
		signIn = new SignInPage(driver);
		
		driver = 	signIn.ChromeDriverConnection();
		
	
		signIn.visit("http://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	
		try {
			
			signIn.signInCase();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
