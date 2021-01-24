package com.project.pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CursoAngularPage extends Base{

	public CursoAngularPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By headerLocalizador             = By.cssSelector("header>h1");
    By crearProductoLinkLocalizador = By.xpath("//a[@href='/crear-producto']");
    By crearProductoH3Localizador  = By.tagName("h3");
    By nombreLocalizador     = By.name("nombre");
    By descripcionLocalizador = By.name("descripcion");
    By precioLocalizador = By.name("precio");
    By crearProductoBtnLocalizador = By.xpath("//input[@value='Crear nuevo producto']");
    By listadoProductoSelector = By.cssSelector("div>h3");
    By nombreListadoLocalizador = By.cssSelector("div[class='caption']>h3");
    
	
	public void RegistrarProducto() throws InterruptedException {
		
		
		if(isDisplayed(headerLocalizador)) {
			
			click(crearProductoLinkLocalizador);
			Thread.sleep(2000);
			
			if(isDisplayed(crearProductoH3Localizador)) {
				
				
				type(nombreLocalizador, "LAPTOP");
				type(descripcionLocalizador, "NUEVA");
				
				clear(precioLocalizador);
				type(precioLocalizador, "2000");
				
				
				click(crearProductoBtnLocalizador);
				Thread.sleep(3000);
				
				if(isDisplayed(listadoProductoSelector)) {
					
					if(getText(nombreListadoLocalizador).equalsIgnoreCase("LAPTOP")) {
						
						
						assertTrue(isDisplayed(nombreListadoLocalizador));

						
					}else {
						
						System.out.println("El nombre del producto no fue encontrado");
					}
					
					
					
				}else {
					System.out.println("El listado de los producto no fue encontrado");

					
				}
				
			}else {
				System.out.println("El formulario crear productos no fue encontrado");

			}
		}else {
			System.out.println("El texto de la cabecera de la pagina no fue encontrado");

		}
		
		
	}
	
	

}
