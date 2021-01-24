package com.checkingLinks.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingLinksPage  {
	
	private WebDriver driver;
	
	public CheckingLinksPage(WebDriver driver) {
		
		
		
		this.driver = driver;

		
	}
	
	
	public boolean checkingPageLink() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		String url="";
		
		List<String> brokerLinks = new ArrayList<String>();
		
		List<String> okLinks = new ArrayList<String>();
		
        HttpURLConnection httpConection = null;
		int responseCode = 200;
		
		Iterator<WebElement> it = links.iterator();
		
		while (it.hasNext()) {
            url	= 	it.next().getAttribute("href");
            
            if(url ==null || url.isEmpty()) {
            	
				System.out.print("Url is empty  or not configured: "+ url);
				continue;

            }
            
            try {
            	httpConection = (HttpURLConnection)(new URL(url).openConnection());
            	httpConection.setRequestMethod("HEAD");
				httpConection.connect();
			     
				responseCode = httpConection.getResponseCode();
				
			if(responseCode>400)	{
				
				System.out.println("INVALID LINKS: "+ url);
            	brokerLinks.add(url);

				
            }else {
            	
            	System.out.println("VALID LINKS: "+ url);
            	okLinks.add(url);
            }
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    	System.out.println("VALID LINKS: "+okLinks.size());
		System.out.println("INVALID LINKS: "+ brokerLinks.size());

		
		if(brokerLinks.size()>0) {
			
			for (int i = 0; i < brokerLinks.size(); i++) {
				
		    	System.out.println("***ERROR LINKS: "+brokerLinks.get(i));

				
			}
			
			return false;
			
		}else {
			
			return true;

		}
	}

	
	
}
