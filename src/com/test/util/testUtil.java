package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testUtil {
	
	//---To read data from excel---//
	
	//static Xls_Reader reader;
	
	static XSSFSheet testDataSheet;
	static XSSFWorkbook myExcel;
	static FileInputStream file;
	static File fis;
	
	public static Object[][] getDataFromExcel()
	{	
		try
		{
			fis = new File("/Users/rahulsingh/Desktop/MyComputer/Automation/TestNgDataDrivenTest.xlsx");
			file = new FileInputStream(fis);
			myExcel = new XSSFWorkbook(file);
			testDataSheet = myExcel.getSheet("TestData");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		int rowCount = testDataSheet.getPhysicalNumberOfRows();
		XSSFRow rownum =  testDataSheet.getRow(0);
		int colCount = rownum.getLastCellNum();
		XSSFCell cell;
		
		Object Data[][]= new Object[rowCount-1][colCount];

		for(int i=1; i < rowCount; i++)
		{	
			for(int j=0; j < colCount; j++)
			{
				XSSFRow row =  testDataSheet.getRow(i);
				cell = row.getCell(j);
				Data[i-1][j] = cell.getStringCellValue();
			}
		}
		
		return Data;
	}	
}
	
	

