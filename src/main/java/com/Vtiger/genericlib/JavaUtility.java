package com.Vtiger.genericlib;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to generate random number till the given value in the form of String.
	 * @param value
	 * @return random number in String form.
	 */
	public String randomData(int value) {
		Random r=new Random();
		int random = r.nextInt(value);
		return ""+random;
	}
	
	/**
	 * This method is used to fetch the current system date.
	 * @return system date in String form
	 */
	public String systemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
}
