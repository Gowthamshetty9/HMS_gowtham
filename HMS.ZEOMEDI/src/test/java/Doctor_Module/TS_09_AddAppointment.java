package Doctor_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.HMS.testyantra.genricutility.fileutility;
import com.HMS.testyantra.genricutility.javautility;
import com.HMS.testyantra.genricutility.webdriverutility;

public class TS_09_AddAppointment {
public static void main(String[] args) throws Throwable {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options);
	fileutility fileutility=new fileutility();
	driver.get(fileutility.Readdatafromfile("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
	driver.findElement(By.name("username")).sendKeys("chandan@outlook.com");
	driver.findElement(By.name("password")).sendKeys("Chandan@123");
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[contains(@href,'book-appointment')]")).click();
	webdriverutility webdriver=new webdriverutility();
	WebElement specialization = driver.findElement(By.name("Doctorspecialization"));
	webdriver.selectdropdownelement(driver, specialization,"Dentist");
	WebElement doctor = driver.findElement(By.id("doctor"));
	webdriver.selectdropdownelement(driver, doctor, "Suhas");
	//driver.findElement(By.name("appdate")).click();
	javautility javautils=new javautility();
	String date = javautils.currentsystemdate();
	driver.findElement(By.name("appdate")).sendKeys(date);
	//driver.findElement(By.xpath("//td[@class='day'][6]")).click();
	//WebElement hour = driver.findElement(By.xpath("//input[contains(@class,'hour form-control')]"));//.clear();
	//hour.clear();
	//hour.sendKeys("11");
	driver.findElement(By.name("submit")).click();
	webdriver.switchtopopup(driver);
	String text = driver.getTitle();
	if (text.equalsIgnoreCase("User  | Book Appointment")) {
		System.out.println("Book Appointment page is displayed");
	}else {
		System.out.println("Book Appointment page is displayed");
	}
}
}
