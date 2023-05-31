package com.HMS.testyantra.genricutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
public String Readdatafromexcelfile(String sheetname,int rowindex,int cellindex) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/HMS.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Cell cell = workbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex);
	DataFormatter dataformatter=new DataFormatter();
	String data = dataformatter.formatCellValue(cell);
	return data;
}
public void Insertdatatocell(String sheetname,int rowindex,int cellindex,String data) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/HMS.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	workbook.createSheet(sheetname).createRow(rowindex).createCell(cellindex).setCellValue(data);
	FileOutputStream fos=new FileOutputStream("./src/test/resources/HMS.xlxs");
	workbook.write(fos);
	workbook.close();
}
public  Object[][] data(String sheetname) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/HMS.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetname);
	int lastrow = sheet.getLastRowNum()+1;
	short lastcell = sheet.getRow(0).getLastCellNum();
	Object[][] arr = new Object[lastrow][lastcell];
	for (int i = 0; i < lastrow; i++) {
		for (int j = 0; j < lastcell; j++) {
			arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return arr;
}
}
