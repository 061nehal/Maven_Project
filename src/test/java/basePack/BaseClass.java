package basePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	 protected static WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nehal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();	
		//System.setProperty("webdriver.gecko.driver", "D:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();			
		
		//driver.manage().window().setSize(new Dimension(700, 600));
		driver.manage().window().maximize();
		
		
	}
	@AfterTest
	public void CloseBrowser() throws Exception {
		Thread.sleep(3000);

		driver.close();
		//driver.quit();
	}

}

