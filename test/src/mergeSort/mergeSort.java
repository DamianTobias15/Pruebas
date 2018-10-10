package mergeSort;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//librerias de Excel 
import banPerUat.transaccionesUat;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;






public class mergeSort  {
	
	 WebDriver driver ;
		
		public void mergeSort(){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrom241\\chromedriver.exe");	  
			driver = new ChromeDriver();
		}


		public static void main(String[] args) {
			
			mergeSort u = new mergeSort();
		u.cargarBrowser();	
	
		
		}
			
		public  WebDriver  cargarBrowser () {
				WebElement elemento ;
		

		
				// abrir navegador 
				driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
		
		
				try {
					//logiin 
				Thread.sleep(2000);
				driver.findElement(By.id("splash-207555-close-button")).click();
				driver.findElement(By.name("username1")).sendKeys("111572424");;
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				driver.findElement(By.id("textFirma")).sendKeys("a1b2c3d4");
				driver.findElement(By.id("enterId")).click();
				driver.findElement(By.id("link_lkTransfers")).click();
				
				
				// lectura Excel 
				
				try {

						Workbook workbook  = Workbook.getWorkbook(new File("C:\\Users\\et77237\\Documents\\qerys")); //Pasamos el excel que vamos a leer
						Sheet sheet = workbook.getSheet("Transaccione"); //Seleccionamos la hoja que vamos a leer
				
						String firstName; 
						System.out.print(sheet.getRows());
				
						//garantiza las mismas condicones como la primera dentro del mismo ciclo
					
							for (int fila = 1; fila < sheet.getRows(); fila++) { //recorremos las filas
							//menu.mnuRegisterLink().click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
							
								driver.findElement(By.id("sourceInstanceID-button")).click();				
								driver.findElement(By.xpath("//*[@id='sourceInstanceID-menu']/li[2]/span")).click();
								scrollUniversal();
								driver.findElement(By.id("sourceInstanceID-menu-option-2")).sendKeys(sheet.getCell(1, fila).getContents());							
								Thread.sleep(3000);		
								}
					}catch(Exception e){
						takeScreenShotTest(driver, "ErrorExcel");
						driver.findElement(By.id("link_logout")).click();
						driver.quit();
					}

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
				} finally {
					takeScreenShotTest(driver, "Error");
					driver.findElement(By.id("link_logout")).click();
					driver.quit();
				}
			
			
			
				
		
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
