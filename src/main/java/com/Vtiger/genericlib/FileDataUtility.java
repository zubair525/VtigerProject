package com.Vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to deal with the data from Properties file
 * 
 * @author zubairahmed
 *
 */
public class FileDataUtility {

	/**
	 * This method is used to read the data from properies file based below
	 * parameter
	 * 
	 * @param key
	 * @return value in the form String
	 * @throws IOException
	 */
	public String fetchDataFromProperty(String key) throws IOException {
		FileInputStream file = new FileInputStream("./commonData.properties");
		Properties pobj = new Properties();
		pobj.load(file);
		String value = pobj.getProperty(key);
		return value;
	}
}
