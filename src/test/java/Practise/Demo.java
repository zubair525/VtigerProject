package Practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger.genericlib.ExcelUtility;
import com.Vtiger.genericlib.JavaUtility;import com.mysql.cj.jdbc.Driver;

public class Demo {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		String random = jutil.randomData(1000);
		String data = eutil.fetchDataFromExcel("Organizations", 5, 5)+""+random;
		System.out.println(data);
		WebDriver driver=null;
		WebDriverWait w=new WebDriverWait(driver, 10);
		//w.until(ExpectedConditions.numberOfWindowsToBe(0))
		
	}
}
