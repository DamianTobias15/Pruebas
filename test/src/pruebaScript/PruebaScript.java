package pruebaScript;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.*;


public class PruebaScript {
	
	public static final String RUTA = "C:\\Users\\et77237\\Documents\\qerys\\SeleniumUat.xlsx";
	static WebDriver driver ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cargarBrowser ();
		onlyUser();
		
		

	}

	
	public  static WebDriver cargarBrowser () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AllLibreries\\chrom241\\chromedriver.exe"); 

	  driver = new ChromeDriver();
		 // abrir navegador 
	driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
		//Cerrar el pop up 
	driver.findElement(By.id("splash-207555-close-button")).click();
	// agregar que se maximizar la pantalla 
	
	return driver;
	
	

	}
	
		
	public static void onlyUser (){
		try {
			
			File src = new File(RUTA);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
			XSSFSheet CompaSheet = wb.getSheetAt(0);
			String origen = null;
			String destino = null;
			
			for (int i = 1; i < sheet1.getLastRowNum(); i++) {
				driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
				System.out.println(sheet1);
				// recorremos las filas
				driver.findElement(By.name("username1")).click();
				String user = (sheet1.getRow(i).getCell(0).getStringCellValue().toString());
				System.out.println(user);
				driver.findElement(By.name("username1"))
						.sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue().toString());
				

				// se realiza el ingreso del password
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				String password = (sheet1.getRow(i).getCell(1).getStringCellValue().toString());
				driver.findElement(By.xpath("//*[@id='textFirma']"))
						.sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue().toString());
				System.out.println(password);
				driver.findElement(By.id("enterId")).click();
				
				// transaccion 
				driver.findElement(By.id("link_lkTransfers")).click();
				scrollUniversal();
				//Origen
				driver.findElement(By.xpath("//*[@id='sourceInstanceID-button']/span[2]")).click();
				driver.findElement(By.xpath("//*[@id='acbol_pnt_mmw_t_sSourceDestinationSelection']")).click();
				origen = (sheet1.getRow(i).getCell(2).getStringCellValue().toString());
				System.out.println(origen);
				driver.findElement(By.xpath("//*[@id='sourceInstanceID-menu-option-1']/span/span[1]/span[.=' - "+origen+"']")).click();
				//destino
				driver.findElement(By.xpath("//*[@id='destinationInstanceID-button']/span[2]"));
				driver.findElement(By.xpath("//*[@id='destinationInstanceID-button']/span[2]"));
				destino  = (sheet1.getRow(i).getCell(3).getStringCellValue().toString());
				driver.findElement(By.xpath("//*[@id='sourceInstanceID-menu-option-1']/span/span[1]/span[.=' - "+destino+"']")).click();
				
			}
			
			
			
			
			
		} catch (Exception e) {
			
			System.out.println("Error en el Loggin ");
			driver.findElement(By.id("link_logout")).click();
		}
		
	}
	
	
		
	public static void waitUrl(int time)	{

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS); 
		} 

	
	public static  void scrollUniversal (){
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		
	}
	
	
}
	

