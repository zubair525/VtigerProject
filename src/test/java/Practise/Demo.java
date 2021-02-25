package Practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.Vtiger.genericlib.ExcelUtility;
import com.Vtiger.genericlib.JavaUtility;

public class Demo {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		String random = jutil.randomData(1000);
		String data = eutil.fetchDataFromExcel("Organizations", 5, 5)+""+random;
		System.out.println(data);
	}
}
