package com.Vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to deal data from Excel
 * 
 * @author zubairahmed
 *
 */
public class ExcelUtility {

	/**
	 * This method is used to read the data from Excel based on the below parameters
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return cellValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String fetchDataFromExcel(String sheetName, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./MyTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}

	/**
	 * This is method is used to read the Number of rows used in Excel based on the
	 * below parameters
	 * 
	 * @param sheetName
	 * @return No of rows used
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./MyTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}

	/**
	 * This method is used to write the data into the Excel based on below
	 * parameters
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param colnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataIntoExcel(String sheetName, int rownum, int colnum, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./MyTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(colnum);
		cell.setCellValue(value);
		FileOutputStream fileO = new FileOutputStream("./MyTestCase.xlsx");
		wb.write(fileO);
		fileO.flush();
	}
}
