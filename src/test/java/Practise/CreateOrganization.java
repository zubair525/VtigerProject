package Practise;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void createOrganization() throws IOException, InterruptedException {
		//Properties file Data
		String url=futil.fetchDataFromProperty("Url");
		String browser = futil.fetchDataFromProperty("Browser");
		String userName = futil.fetchDataFromProperty("UserName");
		String password = futil.fetchDataFromProperty("Password");
	
		
		String random = jutil.randomData(1000);
		
		//Excel File Data
		String SheetName="Organizations";
		String orgName = eutil.fetchDataFromExcel(SheetName, 5, 5)+""+random;
		String webSite = eutil.fetchDataFromExcel(SheetName, 6, 5)+""+random;
		String expTitle = eutil.fetchDataFromExcel(SheetName, 7, 5);
		String selectOrg = eutil.fetchDataFromExcel(SheetName, 8, 5);
		String industry = eutil.fetchDataFromExcel(SheetName, 11, 5);
		String accountType = eutil.fetchDataFromExcel(SheetName, 12, 5);
		String expSuccessMsg = eutil.fetchDataFromExcel(SheetName, 14, 5);
		String expchildUrl="Accounts&action=Popup&popuptype";
		String expMainUrl="DetailView&parenttab=Marketing";
		
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
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("website")).sendKeys(webSite);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//Switch to child window
		wutil.switchToWindowByUrl(driver, expchildUrl);
		
		
		driver.findElement(By.name("search_text")).sendKeys(selectOrg);
		driver.findElement(By.name("search")).click();
		WebElement ee = driver.findElement(By.xpath("//a[text()='"+selectOrg+"']"));
		wutil.waitTillElementIsClickable(driver, 10, ee);
		ee.click();
		
		
		//Switch to alert pop and accept
		wutil.alertAccept(driver);
		
		//Switch to main window
		wutil.switchToWindowByUrl(driver, expMainUrl);
		
		//Validate if window switched to main window
		String actText = driver.findElement(By.xpath("//span[text()='Creating New Organization']")).getText();
		String expText="Creating New Organization";
		if(actText.equalsIgnoreCase(expText)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("fail");
		}
		
		//Select Industry from dropdown
		WebElement dd1 = driver.findElement(By.name("industry"));
		wutil.select(dd1, industry);
		
		//Select Type from dropdown
		WebElement dd2 = driver.findElement(By.name("accounttype"));
		//dd2.click();
		wutil.select(dd2, accountType);
		
		//Enable checkbox
		driver.findElement(By.name("emailoptout")).click();
		
		//Click on save to capture this Organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validating if organization is created successfully
		String actSuccessMsg = driver.findElement(By.xpath("//span[contains(text(),'"+orgName+" -  Organization Information')]")).getText();
		if(actSuccessMsg.contains(expSuccessMsg)) {
			System.out.println("Organization created successfully");
		}
		else {
			System.out.println("Organization not created");
		}
		
		//logout from the application
		WebElement move = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td"));
		wutil.mouseOverToElement(driver, move);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
