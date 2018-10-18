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
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AllLibreries\\chrom241\\chromedriver.exe");	  
		driver = new ChromeDriver();
	} 
	
	public static void main(String[] args) {
		
		LoggOn u = new LoggOn();
		u.cargarBrowser();
	
		
		

	}
	
	public  WebDriver  cargarBrowser () {
		WebElement elemento ;
		
	
		
		
			 // abrir navegador 
		//driver.get("https://www.google.com");
	
		driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
		driver.findElement(By.id("splash-207555-close-button")).click();
		
			try {
				
				File src = new File (RUTA);
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet1 = wb.getSheetAt(1);
				XSSFSheet CompaSheet = wb.getSheetAt(0);
				
				
				String varCom = (CompaSheet.getRow(1).getCell(4).getStringCellValue());
				String varSheet = (sheet1.getRow(1).getCell(4).getStringCellValue().toString());
				System.out.println(varCom + varSheet);
				
					if (varCom==varSheet)   {
						
				// se realiza el ingreso deu usuario 
				driver.findElement(By.name("username1")).click();
				String user = (sheet1.getRow(1).getCell(0).getStringCellValue().toString());
				driver.findElement(By.name("username1")).sendKeys(sheet1.getRow(1).getCell(0).getStringCellValue().toString());
				
				System.out.println(user);
				takeScreenShotTest(driver, "LoggOn");
				
				
				// se realiza el ingreso del password 
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				String password = (sheet1.getRow(1).getCell(1).getStringCellValue().toString());
				driver.findElement(By.xpath("//*[@id='textFirma']")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue().toString());
				System.out.println(password);
				driver.findElement(By.id("enterId")).click();
				driver.findElement(By.id("link_lkTransfers")).click();
				
					}
					else {
						// login diferente a cuenta 1 
						// se realiza el ingreso deu usuario 
						driver.findElement(By.name("username1")).click();
						driver.findElement(By.name("username1")).sendKeys(sheet1.getRow(1).getCell(1).getRawValue().toString());
						takeScreenShotTest(driver, "LoggOn");
						System.out.println(sheet1.getRow(4).getCell(0).getRawValue().toString());
						
						// se realiza el ingreso del password 
						driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
						driver.findElement(By.id("textFirma")).sendKeys(sheet1.getRow(4).getCell(1).getStringCellValue());
						driver.findElement(By.id("enterId")).click();
						driver.findElement(By.id("link_lkTransfers")).click();
						
					}
				
				
				
			
					
				
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

	
	public void transaccionPropiasLoggOn(String user, String password){
		
		driver.findElement(By.name("username1")).click();
		driver.findElement(By.name("username1")).sendKeys(user);
		takeScreenShotTest(driver, "LoggOn");
		// se realiza el ingreso del password 
		driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
		driver.findElement(By.id("textFirma")).sendKeys(password);
		driver.findElement(By.id("enterId")).click();
		driver.findElement(By.id("link_lkTransfers")).click();
		
		
		
	}
	
	public  void transaccionPropias (String cuentaOrigen, String cuentaDestino){
		try {
			
			
		// ComboBoxx captura de de pantalla  Cuenta de Origen 
		driver.findElement(By.id("sourceInstanceID-button")).click();	
		//posible sendskeys  ya que no se tenia ambiente 
		driver.findElement(By.id("sourceInstanceID-button")).sendKeys(cuentaOrigen);
	
		
		//driver.findElement(By.xpath("//*[@id='sourceInstanceID-menu']/li[2]/span")).click();
		scrollUniversal ();			
		takeScreenShotTest(driver, "CuentaOrigen");
		//driver.findElement(By.id("sourceInstanceID-menu-option-2")).click();							
		
			Thread.sleep(3000);
	
			
		// ComboBoxx captura de de pantalla  Cuenta Destino
		driver.findElement(By.id("destinationInstanceID-button")).click();	
		driver.findElement(By.id("destinationInstanceID-button")).sendKeys(cuentaDestino);
		
	//	driver.findElement(By.xpath("//*[@id='destinationInstanceID-menu']/li[2]/span")).click();
	//  driver.findElement(By.xpath("//*[@id='destinationInstanceID-menu-option-1']/span")).click();	
		takeScreenShotTest(driver, "Transacciones");
		Thread.sleep(6000);
		
		// clic en el boton continuar 
		driver.findElement(By.id("cN-primaryNavEnabled")).click();
		Thread.sleep(2000);
		// monto 
		driver.findElement(By.id("Debit-withtext")).sendKeys("75");;
		Thread.sleep(2000);
		scrollUniversal();
		driver.findElement(By.id("InternalTransfer_NextLink_Enabled")).click();					
		Thread.sleep(4000);
		scrollUniversal();
		takeScreenShotTest(driver, "TXN");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 

}
