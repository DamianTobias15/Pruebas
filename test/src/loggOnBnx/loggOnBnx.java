package loggOnBnx;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.*;

public class loggOnBnx extends utilities {
	
	public static final String RUTA = "C:\\Users\\et77237\\Documents\\qerys\\SeleniumUat.xlsx";
	
	

	
	public static void cargarLoggIn(WebDriver driver){
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
		
	}
	
	
	//driver.quit();
	


	
}
