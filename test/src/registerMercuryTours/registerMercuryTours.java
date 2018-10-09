package registerMercuryTours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testLogOn.pruebaT;
import utilities.utilities;


public class registerMercuryTours  extends utilities {
	
		public static void main(String[] args)  {
		// TODO Auto-generated method stub
		registerMercuryTours R = new registerMercuryTours();
		R.registerUser();
		
		}
	
	public void registerUser (){
			
			WebElement elemento ;
			 WebDriver driver = cargarBrowser();
			
			driver.findElement(By.linkText("mercuryregister.php"));
			
			//Contact Information
			
			 driver.findElement(By.name("firstName")).sendKeys("Edgar");
			 driver.findElement(By.name("lastName")).sendKeys("Sandoval");
			 driver.findElement(By.name("phone")).sendKeys("8441567654");
			 driver.findElement(By.id("userName")).sendKeys("EdgarS@gmail.com");
			 
			 //Mailing Information 
			 driver.findElement(By.name("address1")).sendKeys("Sevilla 249");
			 driver.findElement(By.name("city")).sendKeys("Saltillo");
			 driver.findElement(By.name("state")).sendKeys("Saltillo");
			 driver.findElement(By.name("state")).sendKeys("postalCode");
		
		}	
	

}


