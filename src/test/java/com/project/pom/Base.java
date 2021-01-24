package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


	private WebDriver driver;



	public Base(WebDriver driver) {

		this.driver = driver;

	}
	/**
	 * Funcion. Metodo crea instancia del navegador chrome.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */
	public WebDriver ChromeDriverConnection() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}

	/**
	 * Funcion. Metodo busca un elemento del DOM, a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */
	public WebElement findElement(By locator) {


		return driver.findElement(locator);

	}
	
	/**
	 * Funcion. Metodo busca varios elementos del DOM, a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public List<WebElement> findElements(By locator) {


		return driver.findElements(locator);

	}
	
	/**
	 * Funcion. Metodo devuelve el texto de un elemento del DOM, a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public String getText(By locator) {

		return driver.findElement(locator).getText();
	}
	
	/**
	 * Funcion. Metodo devuelve el texto de un elemento del DOM, a traves de un WebElement.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	
	public String getText(WebElement element) {

		return element.getText();
	}
	
	
	/**
	 * Funcion. Metodo permite escribir texto en un elemento.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public void type(By locator, String text) {


		driver.findElement(locator).sendKeys(text);

	}
	
	/**
	 * Funcion. Metodo permite dar clic en un elemento, a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public void click(By locator) {

		driver.findElement(locator).click();

	}
	
	/**
	 * Funcion. Metodo permite dar clic en un elemento, a traves de un WebElement.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */
	
	public void click(WebElement element) {

		element.click();

	}
	
	/**
	 * Funcion. Metodo hacer submit en un elemento, a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public void submit(By locator) {

		driver.findElement(locator).submit();

	}
	
	/**
	 * Funcion. Metodo permite limpiar el contenido de los campos , a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */

	public void clear(By locator) {

		driver.findElement(locator).clear();

	}
	
	/**
	 * Funcion. Metodo permite validar si un elemento se encuentra en pantalla , a traves de un localizador.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */


	public boolean isDisplayed(By locator) {
		
		boolean result= false;
		
		try {
			
			if(driver.findElement(locator).isDisplayed()){
				
				result = true;
			}
			
		}catch (Exception e) {
			
			System.out.print(e);
		}
		
		return result;
	}
	
	
	/**
	 * Funcion. Metodo redirige a una pagina web, segun la url enviada como argumento.
	 * 
	 * 
	 * Fecha. 1 Enero 2021
	 * */
	
	public void visit(String url) {
		
		driver.get(url);
	}

}
