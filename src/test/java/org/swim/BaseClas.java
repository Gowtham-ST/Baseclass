package org.swim;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClas {
	
	public static WebDriver driver;
	
	public static void BrowserLaunch(String browser) {
		
		//nama yalatype browser venum nalum switch case use panurom 
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case"Edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			driver.manage().window().maximize();
           break;
		case"ie":
			WebDriverManager.iedriver().setup();
			driver =new InternetExplorerDriver();
			driver.manage().window().maximize();
           break;

		default:
			
			System.out.println("None of the above");
			break;
		}
	}
		public static void getsURL(String Url) {
			driver.get(Url);
		}
		//set from in adactin from excel
		public static String setvalue(int rows,int cells) {
			
			String value = null ;
			try {
				
				File file = new File("C:\\Users\\welcome\\OneDrive\\Desktop\\wrk.xlsx");	
				FileInputStream stream = new FileInputStream(file);
				Workbook book = new XSSFWorkbook(stream);
				Sheet sheet = book.getSheet("Sheet2");
				Row row = sheet.getRow(rows);
				Cell cell = row.getCell(cells);
				CellType cellType = cell.getCellType();
				switch (cellType) 
				{
				case STRING:
					 value = cell.getStringCellValue();
					
					break;

				default:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date value2 = cell.getDateCellValue();
						SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
						value  = simple.format(value2);
						
					}else {
						double numericCellValue = cell.getNumericCellValue();
						long l= (long)numericCellValue;
						BigDecimal valueof = BigDecimal.valueOf(l);
						value = valueof.toString();
						
					}
					
					
					
					break;
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			return value ;
			
		
	
	}

}

