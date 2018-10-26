package loggOnBnx;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.*;

public class loggOnBnx extends utilities {

	public static final String RUTA = "C:\\Users\\et77237\\Documents\\qerys\\SeleniumUat.xlsx";

	public static void cargarLoggIn(WebDriver driver) {
		try {

			File src = new File(RUTA);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(1);
			XSSFSheet CompaSheet = wb.getSheetAt(0);

			String varCom = (CompaSheet.getRow(1).getCell(4).getStringCellValue());
			String varSheet = (sheet1.getRow(1).getCell(4).getStringCellValue().toString());
			System.out.println(varCom + varSheet);

			// se realiza el ingreso deu usuario

			for (int i = 1; i < sheet1.getLastRowNum(); i++) {
				driver.get("https://uat4.bancapersonal.banamex.com/MXGCB/JPS/portal/Index.do");
				System.out.println(sheet1);
				// recorremos las filas
				driver.findElement(By.name("username1")).click();
				String user = (sheet1.getRow(i).getCell(0).getStringCellValue().toString());
				System.out.println(user);
				driver.findElement(By.name("username1"))
						.sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue().toString());
				System.out.println(user);

				// se realiza el ingreso del password
				driver.findElement(By.xpath("//*[@id='content65']/div[2]/div[2]/a")).click();
				String password = (sheet1.getRow(i).getCell(1).getStringCellValue().toString());
				driver.findElement(By.xpath("//*[@id='textFirma']"))
						.sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue().toString());
				System.out.println(password);
				driver.findElement(By.id("enterId")).click();

				// validacion
				try {
					driver.findElement(By.id("link_lkTransfers")).click();

				} catch (NoSuchElementException e) {
					// TODO: handle exception
					System.out.println("Error en el Loggin ");
				}

				// cerrar sesion

				waitUrl(2);
				driver.findElement(By.id("link_logout")).click();

				/// Pruebas de autentificacion de todos los usuarios

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {

			driver.findElement(By.id("link_logout")).click();
			driver.quit();
		}

	}
	
	
}
