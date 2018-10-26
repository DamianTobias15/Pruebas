package run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import loggOnBnx.loggOnBnx;
import utilities.utilities;
import banPerUat.transaccionesUat;

public class Run extends utilities{
	static WebDriver driver ;
	
	public static void main(String[] args)  {
		
		driver = cargarBrowser();
		loggOnBnx.cargarLoggIn(driver);
		waitUrl(2);
		//transaccionesUat.transaccionesUat(driver);
		  
	}

}
