package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class utilities {
	

	public static void main(String[] args) {
		utilities u = new utilities();
		u.cargarBrowser();
		
	}
		
		public  WebDriver  cargarBrowser () {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrom241\\chromedriver.exe");	  

		 WebDriver driver = new ChromeDriver();
			 // abrir navegador 
		driver.get("http://newtours.demoaut.com/");
		
		return driver;
		}

	

}
