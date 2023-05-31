package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WriteAndReadData1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
	    driver.get("https://www.amazon.in/");
	   List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
	   FileInputStream fis=new FileInputStream("./src/test/resources/amezon.xlsx");
       Workbook create = WorkbookFactory.create(fis);
       Sheet sheet = create.getSheet("Sheet1");
       for (int i = 0; i < alllinks.size(); i++) {
    	   sheet.createRow(i).createCell(0).setCellValue(alllinks.get(i).getAttribute("href"));
	}
      FileOutputStream fos=new FileOutputStream("./src/test/resources/amezon.xlsx");
      create.write(fos);
      create.close();

	for (int i = 0; i < alllinks.size(); i++) {
		String data = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println(data);
	}
	}
}
