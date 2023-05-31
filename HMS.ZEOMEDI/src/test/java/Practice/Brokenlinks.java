package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Brokenlinks {

	public static void main(String[] args) throws Throwable {
	WebDriver driver;
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(options);
    driver.get("https://www.myntra.com/");
   List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
  ArrayList<String> brokenlinks = new ArrayList<String>();
   for (int i = 0; i < alllinks.size(); i++) {
	   String link = alllinks.get(i).getAttribute("href");
	   int statuscode=0;
	   try {
		   URL url=new URL(link);
			  URLConnection urlconnect = url.openConnection();
			  HttpURLConnection httpconnection=(HttpURLConnection) urlconnect;
			  statuscode= httpconnection.getResponseCode();
			  if (statuscode>=400) {
				  brokenlinks.add(link+" "+statuscode);
			  }
	} catch (Exception e) {
		brokenlinks.add(link+" "+statuscode);
		continue;
	} 
   }
   System.out.println(brokenlinks);
   driver.quit();
	}
}
