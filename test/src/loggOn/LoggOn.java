package loggOn;



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

public class LoggOn {
	
	public static final String RUTA = "C:\\Users\\et77237\\Documents\\qerys\\SeleniumUat.xlsx";
	 WebDriver driver ;
	 
	public LoggOn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrom241\\chromedriver.exe");	  
		driver = new ChromeDriver();
	} 
	
	public static void main(String[] args) {
		
		LoggOn u = new LoggOn();
		u.cargarBrowser();
		
		

	}
	
	public  WebDriver  cargarBrowser () {
		WebElement elemento ;
		
	
		
		
			 // abrir navegador 
		driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
		driver.findElement(By.id("splash-207555-close-button")).click();
		
			try {
				
				File src = new File (RUTA);
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet1 = wb.getSheetAt(1);
				
				String var1 = (sheet1.getRow(1).getCell(1).getStringCellValue());
	
				
				
				// se realiza el ingreso deu usuario 
				driver.findElement(By.name("username1")).click();
				driver.findElement(By.name("username1")).sendKeys(sheet1.getRow(1).getCell(0).getRawValue().toString());
				takeScreenShotTest(driver, "LoggOn");
				// se realiza el ingreso del password 
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				driver.findElement(By.id("textFirma")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
				driver.findElement(By.id("enterId")).click();
				driver.findElement(By.id("link_lkTransfers")).click();
				
						
				
				
				
			
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
			} finally {
				takeScreenShotTest(driver, "Error");
				driver.findElement(By.id("link_logout")).click();
				driver.quit();
			}
			
			
			
			//driver.quit();
			
		
		return driver;
		}
	
	
	public  void takeScreenShotTest(WebDriver driver, String imageName) {
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
		

	public  void scrollUniversal (){
				
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		
	}


}
