package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*librerias de Excel jxl  
import banPerUat.transaccionesUat;
import jxl.Sheet;
import jxl.Workbook;
/*
 * 
 */
import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;

//librerias Apache
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class utilities {
	
	 WebDriverWait varWait;
	 static WebDriver driver ;
	 
// este metodo se utliza para cargar el browser 
		public  static WebDriver cargarBrowser () {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AllLibreries\\chrom241\\chromedriver.exe"); 

		 WebDriver driver = new ChromeDriver();
			 // abrir navegador 
		driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
			//Cerrar el pop up 
		driver.findElement(By.id("splash-207555-close-button")).click();
		// agregar que se maximizar la pantalla 
		
		return driver;
		
		
	
		}
// Se crea el metodo del Wait 	
		public static void waitUrl(int time)	{

			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); 
			} 

//Capturas de pantalla 
		public static  void takeScreenShotTest(WebDriver driver, String imageName) {
		      //Directorio donde quedaran las imagenes guardadas
		      File directory = new File("C:\\Users\\et77237\\Documents\\ScreenShot");
		 
		      try {
		         if (directory.isDirectory()) {
		            //Toma la captura de imagen
		            File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		            //Mueve el archivo a la carga especificada con el respectivo nombre
		            FileUtils.copyFile(imagen, new File(directory.getAbsolutePath()   + "\\" + imageName + ".png"));
		         } else {
		            //Se lanza la excepcion cuando no encuentre el directorio
		            throw new IOException("ERROR : La ruta especificada no es un directorio!");
		         }
		      } catch (IOException e) {
		         //Impresion de Excepciones
		         e.printStackTrace();
		      }
		   }
			
//Scroll universal 
		public  void scrollUniversal (){
					
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500);");
			
		}
		
	

}
