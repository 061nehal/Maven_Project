package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class OurWebSiteExcelTest extends BaseClass {
	
	@Test(dataProvider = "OurwebsiteData")
	public static  void OurWebSite(String Fname, String Lname, String Email, String AEmail,String pass, 
			String Month, String Day, String Year , String Gender ) throws InterruptedException {
		driver.get("file:///D:/ITTraining/OurWebSite.html");
		
		driver.findElement(By.id("FN")).sendKeys(Fname);
		driver.findElement(By.id("LN")).sendKeys(Lname);
		driver.findElement(By.id("EM")).sendKeys(Email);
		driver.findElement(By.id("AEM")).sendKeys(AEmail);
		driver.findElement(By.id("PW")).sendKeys(pass);
		
		Select monthSelect=new Select(driver.findElement(By.id("month")));
		monthSelect.selectByVisibleText(Month);
		
		Select daySelect=new Select(driver.findElement(By.id("day")));
		daySelect.selectByVisibleText(Day);
		
		Select yearSelect=new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText(Year);
		
		if(Gender.equalsIgnoreCase("Male")) {
		driver.findElement(By.xpath("/html/body/input[6]")).click();
		}
		else if(Gender.equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath("/html/body/input[7]")).click();
			Thread.sleep (3000);
		}
		
	}
	@DataProvider(name="OurwebsiteData")
	public Object[][] excelReader() throws IOException{
		
		Object[][] object=null;
		
		File f=new File("D:\\ITTraining\\CompanyData\\FacebookData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Data1");
		
		int rowCount=ws.getLastRowNum()-ws.getFirstRowNum();
		int colCount=ws.getRow(0).getLastCellNum();
		
		object=new Object[rowCount][colCount];
		
		for(int i=0; i<rowCount; i=i+1) {
			Row row=ws.getRow(i+1);
			
			for(int j=0; j<row.getLastCellNum(); j=j+1) {
				object[i][j]=row.getCell(j).toString();
			}
		}
		return object;
		
	}
	

}
