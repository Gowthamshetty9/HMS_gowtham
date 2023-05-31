package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	@DataProvider
public  Object[][] data() throws Throwable {
	FileInputStream fis =new FileInputStream("./src/test/resources/HMS.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("dataprovider");
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
	@Test(dataProvider = "data")
	public void travel(String src,String dest,String price ) {
		System.out.println(src+" to "+dest+" price "+price);
	}
}
