package com.crm.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {

	public String getKeyPropValue(String propPath, String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key, "Incorrect Key");
		return propValue;
	}
	
	public String getCellData(String excelPath,String sheet, int r, int c) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		return excelValue;
	}
	
	
	public String getCellData1(String excelPath,String sheet, int r, int c) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 String excelValue1 = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		return excelValue1;
	}
	
	
	public int getRowCount(String excelPath,String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	
	public void setCellData(String excelPath,String sheet, int r, int c,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(r).createCell(c).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();
	
	}

//	public String getStringCellValue(String excelPath, String string, int i, int j) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
