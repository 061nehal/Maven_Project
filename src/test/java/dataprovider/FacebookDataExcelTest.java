package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class FacebookDataExcelTest extends BaseClass {
	
	
	@Test(dataProvider = "excelData")
	public void facebookSignUp(String MN, String DY, String YR, String Gender ) {
		//System.out.println(MN+" "+DY+" "+YR+" "+Gender);
		driver.findElement(By.name("firstname")).sendKeys(MN);
	}
	
	
	@DataProvider(name="excelData")
	public Object[][] excelReader() throws IOException{
		
		Object[][] object=null;
		
		File f=new File("D:\\ITTraining\\CompanyData\\FacebookData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Data3");
		
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
