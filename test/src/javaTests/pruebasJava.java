package javaTests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//librerias Apache
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class pruebasJava {
	 private Scanner teclado;
	 private int[] sueldos;
	 public static final String RUTA = "C:\\Users\\et77237\\Documents\\qerys\\SeleniumUat.xlsx";

	 public void cargar()
	    {
	        teclado=new Scanner(System.in);
	        sueldos=new int[5];
	        for(int f=0;f<5;f++) {
	            System.out.print("Ingrese valor de la componente:");
	            sueldos[f]=teclado.nextInt();
	        }	
	    }
		
	    public void imprimir() {
	        for(int f=0;f<5;f++) {
	        	int suma = f + f;
	            System.out.println(sueldos[f] +suma );
	        }
	    }
	    
	public static void main(String[] args) {
		
		
		pruebasJava pv=new pruebasJava();
	        //pv.cargar();
	        //pv.imprimir();
	        pv. lecturaExcel();
	        

	}
	
	public static void lecturaExcel () {
		
		
		
		try {

			File src = new File (RUTA);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
		
		String var1 = (sheet1.getRow(1).getCell(1).getStringCellValue());
		System.out.println(var1);
	
			//garantiza las mismas condicones como la primera dentro del mismo ciclo
		
		//Recorrer el eexcel 
				for (int fila = 0; fila < sheet1.getLastRowNum(); fila++) { //recorremos las filas
					System.out.println(sheet1.getRow(1).getCell(2));
				}
		}
		catch(Exception e) {
			System.out.println("Erro");
		}
	}

}
