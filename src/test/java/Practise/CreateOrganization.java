package Practise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger.genericlib.ExcelUtility;
import com.Vtiger.genericlib.FileDataUtility;
import com.Vtiger.genericlib.JavaUtility;
import com.Vtiger.genericlib.WebDriverUtilities;


public class CreateOrganization {
	FileDataUtility futil=new FileDataUtility();
	WebDriverUtilities wutil=new WebDriverUtilities();
	ExcelUtility eutil=new ExcelUtility();
	JavaUtility jutil=new JavaUtility();
	@Test
	public void createOrganization() throws IOException {
		//Properties file Data
		String url=futil.fetchDataFromProperty("Url");
		String browser = futil.fetchDataFromProperty("Browser");
		String userName = futil.fetchDataFromProperty("UserName");
		String password = futil.fetchDataFromProperty("Password");
		
		String random = jutil.randomData(1000);
		
		//Excel File Data
		String SheetName="Organizations";
		String orgName = eutil.fetchDataFromExcel(SheetName, 5, 5)+""+random;
		
		//Launch Browser
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		wutil.maximizeWindow(driver);
		wutil.waitTillPageIsLoaded(driver, 20);
		
		//login to application
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations page
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Create Organizations
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		//driver.findElement(By.name("accountname"))
		
		
	}
}
