package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CursoAngularTest {

	private WebDriver driver;
	private CursoAngularPage cursoPage;
	
	@Before
	public void setUp() throws Exception {
		
		cursoPage = new CursoAngularPage(driver);
		cursoPage.ChromeDriverConnection();
		cursoPage.visit("http://curso-produccion.com.devel/");
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void test() throws InterruptedException {
		
		cursoPage.RegistrarProducto();
	}

}
