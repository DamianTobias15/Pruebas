package testLogOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.utilities;


public class pruebaT extends utilities{

	public static void main(String[] args) {
	
			pruebaT P = new pruebaT();
		P.logON();
		
	}
	 
public void logON(){
	
		WebElement elemento ;
		
		 
		  

		  WebDriver driver = cargarBrowser();
		
		  	try {
		  driver.findElement(By.name("userName")).sendKeys("Adrian123");
		  driver.findElement(By.name("password")).sendKeys("123");
		  driver.findElement(By.name("login")).click();
		  	}
		  	catch (Exception e) {
		  		System.out.println("error");
		  	}
	
 	}

}