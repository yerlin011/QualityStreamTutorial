package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTest {
	

	private WebDriver driver;
	
	private RegisterPage register;
	
	

	@Before
	public void setUp() throws Exception {
		
		register = new RegisterPage(driver);
		
		driver = register.ChromeDriverConnection();
		
		register.visit("http://demo.guru99.com/test/newtours/");
		
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void test() {
		
		try {
			register.registerCase();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
